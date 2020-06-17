package leetcode.leetcode1xx.leetcode130;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static final int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static final char tmp = '#';

    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;
        if (n == 0) return;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(new int[]{0, i});
            queue.add(new int[]{m - 1, i});
        }
        for (int i = 0; i < m; i++) {
            queue.add(new int[]{i, 0});
            queue.add(new int[]{i, n - 1});
        }
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int i = p[0];
            int j = p[1];
            if (board[i][j] == 'O') {
                for (int[] move : moves) {
                    int newI = i + move[0];
                    int newJ = j + move[1];
                    if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && board[newI][newJ] == 'O') {
                        queue.add(new int[]{newI, newJ});
                    }
                }
                board[i][j] = tmp;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == tmp) board[i][j] = 'O';
            }
        }
    }
}
