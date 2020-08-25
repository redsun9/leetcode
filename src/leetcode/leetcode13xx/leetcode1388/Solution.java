package leetcode.leetcode13xx.leetcode1388;

public class Solution {
    public int maxSizeSlices(int[] slices) {
        int n = slices.length;
        int k = n / 3;
        int[][] dp = new int[n + 1][k + 1];
        for (int j = 1; j <= k; j++) {
            for (int i = 0; i < n - 1; i++) {
                dp[i + 2][j] = Math.max(dp[i][j - 1] + slices[i], dp[i + 1][j]);
            }
        }
        int ans = dp[n][k];
        for (int j = 1; j <= k; j++) {
            for (int i = 1; i < n; i++) {
                dp[i + 1][j] = Math.max(dp[i - 1][j - 1] + slices[i], dp[i][j]);
            }
        }
        ans = Math.max(ans, dp[n][k]);
        return ans;
    }
}
