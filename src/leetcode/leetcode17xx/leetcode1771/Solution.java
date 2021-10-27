package leetcode.leetcode17xx.leetcode1771;

public class Solution {
    public int longestPalindrome(String word1, String word2) {
        int m = word1.length(), n = word2.length(), k = m + n;
        char[] a = word1.toCharArray(), b = word2.toCharArray();
        char[] c = new char[k];
        System.arraycopy(a, 0, c, 0, m);
        System.arraycopy(b, 0, c, m, n);

        int[][] dp = new int[k][k];
        for (int i = 0; i < k; i++) dp[i][i] = 1;
        for (int d = 2; d <= k; d++) {
            for (int i = 0, j = d - 1; j < k; i++, j++) {
                if (c[i] == c[j]) dp[i][j] = dp[i + 1][j - 1] + 2;
                else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0, pos = m - 1; j < n; j++, pos++) {
                if (a[i] == b[j]) ans = Math.max(ans, dp[i + 1][pos] + 2);
            }
        }
        return ans;
    }
}
