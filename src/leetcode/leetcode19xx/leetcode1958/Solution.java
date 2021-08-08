package leetcode.leetcode19xx.leetcode1958;

public class Solution {
    private static final int n = 8;

    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        if (board[rMove][cMove] != '.') return false;
        char oppositeColor = (char) ('W' + 'B' - color);
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) continue;
                int x = rMove + dx, y = cMove + dy;
                while (x >= 0 && x < n && y >= 0 && y < n && board[x][y] == oppositeColor) {
                    x += dx;
                    y += dy;
                }
                if (x >= 0 && x < n && y >= 0 && y < n && board[x][y] == color) {
                    int d = (Math.abs(x - rMove) + Math.abs(y - cMove)) / (Math.abs(dx) + Math.abs(dy));
                    if (d >= 2) return true;
                }
            }
        }
        return false;
    }
}
