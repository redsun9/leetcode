package leetcode.leetcode10xx.leetcode1039;

public class Solution {
    public int minScoreTriangulation(int[] a) {
        int n = a.length;
        int[][] dp = new int[n][n];
        for (int d = 2; d < n; d++) {
            for (int i = 0, k = d; k < n; i++, k++) {
                int min = Integer.MAX_VALUE;
                for (int j = i + 1; j < k; j++) min = Math.min(min, dp[i][j] + dp[j][k] + a[i] * a[j] * a[k]);
                dp[i][k] = min;
            }
        }
        return dp[0][n - 1];
    }
}
