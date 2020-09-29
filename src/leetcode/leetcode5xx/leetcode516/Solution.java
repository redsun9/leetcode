package leetcode.leetcode5xx.leetcode516;

// O(n^2) - time, O(n^2) - space
public class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        if (n <= 1) return n;
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
