package leetcode.leetcode5xx.leetcode529;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    private static final char UNREVEALED_MINE = 'M';
    private static final char UNREVEALED_EMPTY = 'E';
    private static final char REVEALED_ZERO = 'B';
    private static final char REVEALED_MINE = 'X';


    public char[][] updateBoard(char[][] board, int[] click) {
        int i = click[0], j = click[1];
        if (board[i][j] == UNREVEALED_MINE) {
            board[i][j] = REVEALED_MINE;
        } else {
            int m = board.length, n = board[0].length;
            Queue<int[]> queue = new ArrayDeque<>();
            int cnt = countMines(i, j, m, n, board);
            board[i][j] = cnt == 0 ? REVEALED_ZERO : (char) ('0' + cnt);

            if (cnt == 0) queue.add(new int[]{i, j});
            while (!queue.isEmpty()) {
                click = queue.poll();
                i = click[0];
                j = click[1];
                for (int di = -1; di <= 1; di++) {
                    int nextI = i + di;
                    if (nextI < 0 || nextI == m) continue;
                    for (int dj = -1; dj <= 1; dj++) {
                        if (di == 0 && dj == 0) continue;
                        int nextJ = j + dj;
                        if (nextJ < 0 || nextJ == n || board[nextI][nextJ] != UNREVEALED_EMPTY) continue;
                        cnt = countMines(nextI, nextJ, m, n, board);
                        board[nextI][nextJ] = cnt == 0 ? REVEALED_ZERO : (char) ('0' + cnt);
                        if (cnt == 0) queue.add(new int[]{nextI, nextJ});
                    }
                }
            }
        }
        return board;
    }

    private static int countMines(int i, int j, int m, int n, char[][] board) {
        int cnt = 0;
        for (int di = -1; di <= 1; di++) {
            int nextI = i + di;
            if (nextI < 0 || nextI == m) continue;
            for (int dj = -1; dj <= 1; dj++) {
                if (di == 0 && dj == 0) continue;
                int nextJ = j + dj;
                if (nextJ < 0 || nextJ == n) continue;
                char c = board[nextI][nextJ];
                if (c == UNREVEALED_MINE || c == REVEALED_MINE) cnt++;
            }
        }
        return cnt;
    }
}
