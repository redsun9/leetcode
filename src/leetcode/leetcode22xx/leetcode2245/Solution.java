package leetcode.leetcode22xx.leetcode2245;

public class Solution {
    public int maxTrailingZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] h = new int[2][m + 1][n], w = new int[2][m][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = grid[i][j];
                int two = 0;
                while (num % 2 == 0) {
                    num /= 2;
                    two++;
                }
                int five = 0;
                while (num % 5 == 0) {
                    num /= 5;
                    five++;
                }
                h[0][i + 1][j] = h[0][i][j] + two;
                h[1][i + 1][j] = h[1][i][j] + five;
                w[0][i][j + 1] = w[0][i][j] + two;
                w[1][i][j + 1] = w[1][i][j] + five;
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, Math.min(
                        w[0][i][n] - w[0][i][j] + h[0][m][j] - h[0][i + 1][j],
                        w[1][i][n] - w[1][i][j] + h[1][m][j] - h[1][i + 1][j]));
                ans = Math.max(ans, Math.min(
                        w[0][i][n] - w[0][i][j] + h[0][i][j],
                        w[1][i][n] - w[1][i][j] + h[1][i][j]));
                ans = Math.max(ans, Math.min(
                        w[0][i][j + 1] + h[0][m][j] - h[0][i + 1][j],
                        w[1][i][j + 1] + h[1][m][j] - h[1][i + 1][j]));
                ans = Math.max(ans, Math.min(
                        w[0][i][j + 1] + h[0][i][j],
                        w[1][i][j + 1] + h[1][i][j]));
            }
        }

        return ans;
    }
}
