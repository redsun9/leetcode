package leetcode.leetcode10xx.leetcode1035;

import java.util.Arrays;

public class Solution2 {
    public int maxUncrossedLines(int[] a, int[] b) {
        int m = a.length, n = b.length;
        if (m == 0 || n == 0) return 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        return lcs(a, b, m, n, dp);
    }

    private static int lcs(int[] a, int[] b, int i, int j, int[][] dp) {
        if (i == 0 || j == 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int ans;
        if (a[i - 1] == b[j - 1]) {
            ans = 1 + lcs(a, b, i - 1, j - 1, dp);
        } else {
            ans = Math.max(lcs(a, b, i - 1, j, dp), lcs(a, b, i, j - 1, dp));
        }
        dp[i][j] = ans;
        return ans;
    }
}
