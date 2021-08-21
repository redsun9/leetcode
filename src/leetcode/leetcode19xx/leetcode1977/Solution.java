package leetcode.leetcode19xx.leetcode1977;

@SuppressWarnings("DuplicatedCode")
class Solution {
    private static final int p = 1_000_000_007;

    public int numberOfCombinations(String num) {
        int n = num.length();
        if (num.charAt(0) == '0') return 0;
        if (n == 1) return 1;
        long[][] dp = new long[n][n];
        long[] total = new long[n + 1];

        for (int i = 0; i < n; i++) dp[0][i] = 1;
        total[0] = 1;
        total[1] = 1;

        for (int i = 1; i < n; i++) {
            for (int d1 = 1; d1 <= i; d1++) {
                if (num.charAt(i - d1 + 1) == '0') continue;
                if (i + 1 < 2 * d1) {
                    dp[i - d1 + 1][i] += total[i - d1 + 1];
                    if (dp[i - d1 + 1][i] >= p) dp[i - d1 + 1][i] -= d1;
                } else {
                    for (int d2 = 1; d2 < d1; d2++) {
                        dp[i - d1 + 1][i] += dp[i - d1 - d2 + 1][i - d1];
                        if (dp[i - d1 + 1][i] >= p) dp[i - d1 + 1][i] -= d1;
                    }
                    if (ok(num, i - 2 * d1 + 1, i - d1 + 1, d1)) {
                        dp[i - d1 + 1][i] += dp[i - 2 * d1 + 1][i - d1];
                        if (dp[i - d1 + 1][i] >= p) dp[i - d1 + 1][i] -= d1;
                    }
                }
            }
            total[i + 1] = 0;
            for (int j = 0; j <= i; j++) {
                total[i + 1] += dp[j][i];
                if (total[i + 1] >= p) total[i + 1] -= p;
            }
        }
        return (int) total[n];
    }

    private static boolean ok(String num, int start1, int start2, int len) {
        while (len-- > 0) {
            char c1 = num.charAt(start1++), c2 = num.charAt(start2++);
            if (c1 > c2) return false;
            if (c1 < c2) return true;
        }
        return true;
    }
}