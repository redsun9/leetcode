package leetcode.leetcode0xx.leetcode72;

public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m == 0 || n == 0) return Math.max(m, n);
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i + 1][j + 1] = Math.min(
                        Math.min(dp[i][j + 1], dp[i + 1][j]) + 1,
                        dp[i][j] + (word1.charAt(i) == word2.charAt(j) ? 0 : 1)
                );
            }
        }
        return dp[m][n];
    }
}
