package leetcode.leetcode7xx.leetcode730;

import java.util.Arrays;

public class Solution {
    private static final int p = 1_000_000_007;

    public int countPalindromicSubsequences(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i++) chars[i] -= 'a';

        int[][] left = new int[n + 1][26], right = new int[n + 1][26];


        Arrays.fill(left[0], -1);
        for (int i = 0; i < n; i++) {
            System.arraycopy(left[i], 0, left[i + 1], 0, 26);
            left[i + 1][chars[i]] = i;
        }

        Arrays.fill(right[n], n);
        for (int i = n - 1; i >= 0; i--) {
            System.arraycopy(right[i + 1], 0, right[i], 0, 26);
            right[i][chars[i]] = i;
        }

        int[][] dp = new int[n][n];
        return dfs(0, n - 1, left, right, dp);
    }

    private static int dfs(int start, int end, int[][] left, int[][] right, int[][] dp) {
        if (start > end) return 0;
        if (dp[start][end] == 0) {
            long tmp = 0;
            for (int i = 0; i < 26; i++) {
                int nextStart = right[start][i];
                if (nextStart > end) continue;
                tmp++;
                int nextEnd = left[end + 1][i];
                if (nextStart != nextEnd) {
                    tmp++;
                    tmp += dfs(nextStart + 1, nextEnd - 1, left, right, dp);
                }
            }
            dp[start][end] = (int) (tmp % p + 1);
        }
        return dp[start][end] - 1;
    }
}
