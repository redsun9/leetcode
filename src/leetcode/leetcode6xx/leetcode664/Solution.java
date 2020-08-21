package leetcode.leetcode6xx.leetcode664;

//bottom-up
public class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = 1;
        for (int i = n - 2; i >= 0; i--) dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1) ? 1 : 2;

        for (int l = 2; l < n; l++) {
            for (int j = l; j < n; j++) {
                int i = j - l;
                int min = l + 1;
                for (int k = i; k < j; k++) {
                    min = Math.min(min, dp[i][k] + dp[k + 1][j] + (s.charAt(k) == s.charAt(j) ? -1 : 0));
                }
                dp[i][j] = min;
            }
        }
        return dp[0][n - 1];
    }
}
