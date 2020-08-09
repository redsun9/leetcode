package leetcode.leetcode0xx.leetcode97;

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int k = s3.length();
        if (m + n != k) return false;
        if (m == 0) return s2.equals(s3);
        if (n == 0) return s1.equals(s3);
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i < m; i++) dp[i + 1][0] = dp[i][0] && s1.charAt(i) == s3.charAt(i);
        for (int j = 0; j < n; j++) dp[0][j + 1] = dp[0][j] && s2.charAt(j) == s3.charAt(j);
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                        || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[m][n];
    }
}
