package binsearch.binsearch283;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("ConstantConditions")
public class Solution {
    private static final int[] moves = {1, 0, -1, 0, 1};

    public int solve(int[][] board) {
        Set<Long> set = new HashSet<>();
        ArrayDeque<Long> queue = new ArrayDeque<>();
        long key = calculateKey(board);
        queue.offer(key);
        set.add(key);
        int ans = 1;

        long target = calculateKey(new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}});

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- != 0) {
                board = calculateBoard(queue.pollFirst());
                int zeroX = 0, zeroY = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[i][j] == 0) {
                            zeroX = i;
                            zeroY = j;
                        }
                    }
                }
                for (int k = 0; k < 4; k++) {
                    int newX = zeroX + moves[k], newY = zeroY + moves[k + 1];
                    if (newX < 0 || newX >= 3 || newY < 0 || newY >= 3) continue;
                    swap(board, zeroX, zeroY, newX, newY);
                    long newKey = calculateKey(board);
                    if (newKey == target) return ans;
                    if (set.add(newKey)) queue.addLast(newKey);
                    swap(board, zeroX, zeroY, newX, newY);
                }
            }
            ans++;
        }
        return -1;
    }

    private static void swap(int[][] board, int i1, int j1, int i2, int j2) {
        int tmp = board[i1][j1];
        board[i1][j1] = board[i2][j2];
        board[i2][j2] = tmp;
    }

    private static long calculateKey(int[][] board) {
        long key = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                key |= (long) board[i][j] << ((i * 3 + j) * 4);
            }
        }
        return key;
    }

    private static int[][] calculateBoard(long key) {
        int[][] board = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = (int) ((key >> ((i * 3 + j) * 4)) & 0b1111);
            }
        }
        return board;
    }
}
