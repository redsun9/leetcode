package leetcode.leetcode10xx.leetcode1092;

@SuppressWarnings("DuplicatedCode")
public class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        String lcs = lcs(str1, str2);
        int n1 = str1.length(), n2 = str2.length(), n = lcs.length();
        char[] ans = new char[n1 + n2 - n];
        int i1 = 0, i2 = 0, pos = 0;
        for (int i = 0; i < n; i++, i1++, i2++) {
            char c = lcs.charAt(i);
            while (str1.charAt(i1) != c) ans[pos++] = str1.charAt(i1++);
            while (str2.charAt(i2) != c) ans[pos++] = str2.charAt(i2++);
            ans[pos++] = c;
        }
        while (i1 < n1) ans[pos++] = str1.charAt(i1++);
        while (i2 < n2) ans[pos++] = str2.charAt(i2++);
        return new String(ans);
    }

    //longest common subsequence
    private static String lcs(String x, String y) {
        int m = x.length(), n = y.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (x.charAt(i) == y.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        char[] ans = new char[dp[0][0]];
        int i = 0, j = 0, pos = 0;
        while (i < m && j < n) {
            if (x.charAt(i) == y.charAt(j)) {
                ans[pos++] = x.charAt(i);
                i++;
                j++;
            } else if (dp[i + 1][j] >= dp[i][j + 1]) i++;
            else j++;
        }
        return new String(ans);
    }
}
