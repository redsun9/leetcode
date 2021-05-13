package leetcode.leetcode4xx.leetcode474;

public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int[] count = new int[2];
            for (int i = str.length() - 1; i >= 0; i--) count[str.charAt(i) - '0']++;
            for (int i1 = m, i2 = m - count[0]; i2 >= 0; i1--, i2--) {
                for (int j1 = n, j2 = n - count[1]; j2 >= 0; j1--, j2--) {
                    dp[i1][j1] = Math.max(dp[i1][j1], 1 + dp[i2][j2]);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}
