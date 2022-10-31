package leetcode.leetcode15xx.leetcode1531;

import java.util.Arrays;

import static java.lang.Math.min;

public class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();
        if (n <= k + 2) return n - k;

        int[][] dp = new int[n + 1][k + 1];
        for (int[] array : dp) Arrays.fill(array, -1);
        return dfs(s, 0, k, dp);
    }

    private static int dfs(String s, int left, int K, int[][] dp) {
        int k = K, n = s.length();
        if (n - left <= k) return 0;
        if (dp[left][k] >= 0) return dp[left][k];
        int res = k != 0 ? dfs(s, left + 1, k - 1, dp) : 10000, c = 1;
        for (int i = left + 1; i <= n; ++i) {
            res = min(res, dfs(s, i, k, dp) + 1 + (c >= 100 ? 3 : (c >= 10 ? 2 : (c > 1 ? 1 : 0))));
            if (i == n) break;
            if (s.charAt(i) == s.charAt(left)) ++c;
            else if (--k < 0) break;
        }
        return dp[left][K] = res;
    }
}
