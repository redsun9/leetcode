package leetcode.leetcode39xx.leetcode3933;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Solution {
    public int countLocalMaximums(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int maxVal = 0;
        for (int[] row : matrix) for (int a : row) maxVal = max(maxVal, a);

        int[][][] dp = new int[m + 1][n + 1][maxVal + 2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 1; k <= maxVal; k++) dp[i + 1][j + 1][k] = dp[i][j + 1][k] + dp[i + 1][j][k] - dp[i][j][k];
                for (int k = 1; k < matrix[i][j]; k++) dp[i + 1][j + 1][k]++;
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) if (check(i, j, matrix, dp)) ans++;
        return ans;
    }

    private static boolean check(int i, int j, int[][] matrix, int[][][] dp) {
        int val = matrix[i][j];
        if (val == 0) return false;
        int m = matrix.length, n = matrix[0].length;

        int a1 = max(0, i - val), a2 = min(m - 1, i + val), b1 = max(0, j - val), b2 = min(n - 1, j + val);
        int cntRect = cntRect(dp, val, a1, a2, b1, b2);
        if (i - val >= 0 && j - val >= 0 && matrix[i - val][j - val] > val) cntRect--;
        if (i - val >= 0 && j + val < n && matrix[i - val][j + val] > val) cntRect--;
        if (i + val < m && j - val >= 0 && matrix[i + val][j - val] > val) cntRect--;
        if (i + val < m && j + val < n && matrix[i + val][j + val] > val) cntRect--;
        return cntRect == 0;
    }

    private static int cntRect(int[][][] dp, int val, int a1, int a2, int b1, int b2) {
        return dp[a2 + 1][b2 + 1][val] - dp[a2 + 1][b1][val] - dp[a1][b2 + 1][val] + dp[a1][b1][val];
    }
}
