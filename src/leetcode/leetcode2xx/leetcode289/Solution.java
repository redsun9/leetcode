package leetcode.leetcode2xx.leetcode289;

public class Solution {
    private static final int[][] moves = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}};

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] move : moves) {
                    int x = i + move[0];
                    int y = j + move[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && ((board[x][y] & 1) != 0)) {
                        board[i][j] += 2;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] >= 5 && board[i][j] <= 7 ? 1 : 0;
            }
        }
    }
}
