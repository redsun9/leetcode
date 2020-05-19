package leetcode.leetcode13xx.leetcode1314;

public class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i + 1][j + 1] = mat[i][j] + dp[i + 1][j] + dp[i][j + 1] - dp[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            int down = Math.max(0, i - k);
            int top = Math.min(m, i + k + 1);
            for (int j = 0; j < n; j++) {
                int left = Math.max(0, j - k);
                int right = Math.min(n, j + k + 1);
                mat[i][j] = dp[top][right] - dp[top][left] - dp[down][right] + dp[down][left];
            }
        }
        return mat;
    }
}
