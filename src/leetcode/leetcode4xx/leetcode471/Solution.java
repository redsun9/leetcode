package leetcode.leetcode4xx.leetcode471;

import java.util.Arrays;

@SuppressWarnings("DuplicatedCode")
public class Solution {
    private static final int[] primes = {2, 3, 5, 7, 11};

    /**
     * @param s: a string
     * @return return a string
     */
    public String encode(String s) {
        int n = s.length();
        if (n <= 2) return s;

        char[] a = s.toCharArray();
        int[][] lcp = longestCommonPrefixes(s);
        int[][] lrs = longestRepeatingPrefixes(lcp);
        int[][] factors = factors(n);
        int[][][] dp = calcMinLength(lrs, factors);
        char[] ans = new char[dp[0][n - 1][0]];
        constructMinLength(0, n - 1, 0, a, ans, dp);
        return new String(ans);
    }


    private static int[][] factors(int n) {
        int[][] ans = new int[n + 1][];
        for (int i = 2; i <= n; i++) {
            int[] factors = new int[3]; // numbers below 160 have at most
            int factorsNumber = 0;
            int tmp = i;
            for (int prime : primes) {
                if (tmp % prime == 0) factors[factorsNumber++] = prime;
                while (tmp % prime == 0) tmp /= prime;
            }
            if (tmp != 1) factors[factorsNumber++] = tmp;
            ans[i] = Arrays.copyOfRange(factors, 0, factorsNumber);
        }
        return ans;
    }

    private static int[][][] calcMinLength(int[][] lrs, int[][] factors) {
        int n = lrs.length;
        int[][][] dp = new int[n][n][2];
        for (int d = 1; d <= n; d++) {
            if (d < 4) {
                for (int i = 0, j = d - 1; j < n; i++, j++) dp[i][j][0] = d;
                continue;
            }

            for (int l = 0, r = d - 1; r < n; l++, r++) {
                int min = d;
                for (int m = l; m < r; m++) {
                    int tmp = dp[l][m][0] + dp[m + 1][r][0];
                    if (min <= tmp) continue;
                    min = tmp;
                    dp[l][r][1] = -m - 1;
                }

                int maxRepeat = 1;
                for (int prime : factors[d]) {
                    int tmpRepeat = maxRepeat * prime;
                    while (d % tmpRepeat == 0 && lrs[l][l + d / tmpRepeat] + 1 >= tmpRepeat) {
                        maxRepeat = tmpRepeat;
                        tmpRepeat *= prime;
                    }
                }
                int digits = maxRepeat < 10 ? 1 : maxRepeat < 100 ? 2 : 3;
                if (maxRepeat != 1 && min > digits + 2 + dp[l][l + d / maxRepeat - 1][0]) {
                    min = digits + 2 + dp[l][l + d / maxRepeat - 1][0];
                    dp[l][r][1] = maxRepeat;
                }
                dp[l][r][0] = min;
            }
        }
        return dp;
    }

    private static void constructMinLength(int i1, int j1, int i2, char[] a, char[] ans, int[][][] dp) {
        if (dp[i1][j1][1] == 0) System.arraycopy(a, i1, ans, i2, j1 - i1 + 1);
        else if (dp[i1][j1][1] < 0) {
            int mid = -dp[i1][j1][1] - 1;
            constructMinLength(i1, mid, i2, a, ans, dp);
            constructMinLength(mid + 1, j1, i2 + dp[i1][mid][0], a, ans, dp);
        } else {
            int repeat = dp[i1][j1][1];
            int d = (j1 - i1 + 1) / repeat;
            int lenOfRepeat = dp[i1][i1 + d - 1][0];

            if (repeat < 10) {
                ans[i2] = (char) ('0' + repeat);
                i2 += 1;
            } else if (repeat < 100) {
                ans[i2] = (char) ('0' + repeat / 10);
                ans[i2 + 1] = (char) ('0' + repeat % 10);
                i2 += 2;
            } else {
                ans[i2] = (char) ('0' + repeat / 100);
                ans[i2 + 1] = (char) ('0' + repeat / 10 % 10);
                ans[i2 + 2] = (char) ('0' + repeat % 10);
                i2 += 3;
            }
            ans[i2++] = '[';
            constructMinLength(i1, i1 + d - 1, i2, a, ans, dp);
            ans[i2 + lenOfRepeat] = ']';
        }
    }

    private static int[][] longestCommonPrefixes(String s) {
        int n = s.length();
        int[][] lcp = new int[n][n + 1]; // cp[i][j] - length of common prefix, i>j
        for (int d = 1; d < n; d++) {
            for (int j = n - 1, i = j - d; i >= 0; i--, j--) {
                if (s.charAt(i) == s.charAt(j)) lcp[i][j] = lcp[i + 1][j + 1] + 1;
            }
        }
        return lcp;
    }

    private static int[][] longestRepeatingPrefixes(int[][] lcp) {
        int n = lcp.length;
        int[][] lrs = new int[n][n + 1]; // lrs[i][j] - how many times a[i:j] repeats
        for (int d = 1; d <= n / 2; d++) {
            for (int l3 = n, l2 = n - d, l1 = n - 2 * d; l1 >= 0; l3--, l2--, l1--) {
                if (lcp[l1][l2] >= d) lrs[l1][l2] = lrs[l2][l3] + 1;
            }
        }
        return lrs;
    }
}
