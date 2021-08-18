package leetcode.leetcode7xx.leetcode712;

public class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) dp[i + 1][0] = dp[i][0] + s1.charAt(i);
        for (int j = 0; j < n; j++) dp[0][j + 1] = dp[0][j] + s2.charAt(j);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int c1 = s1.charAt(i), c2 = s2.charAt(j);
                if (c1 == c2) dp[i + 1][j + 1] = dp[i][j];
                else dp[i + 1][j + 1] = Math.min(c1 + dp[i][j + 1], c2 + dp[i + 1][j]);
            }
        }
        return dp[m][n];
    }
}
