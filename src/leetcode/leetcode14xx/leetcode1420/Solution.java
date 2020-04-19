package leetcode.leetcode14xx.leetcode1420;

import java.math.BigInteger;

public class Solution {
    private static final int p = 1_000_000_007;
    private static final BigInteger bigP = BigInteger.valueOf(p);

    public int numOfArrays(int n, int m, int k) {
        long[][][] dp = new long[n][m][k];
        //для k=1
        for (int i = 1; i <= m; i++) {
            dp[0][i - 1][0] = 1;
        }
        for (int k1 = 2; k1 <= k; k1++) {
            for (int m1 = k1; m1 <= m; m1++) {
                for (int n1 = k1; n1 <= n; n1++) {
                    long sum = 0;
                    for (int m2 = k1 - 1; m2 <= m1 - 1; m2++) {
                        for (int n2 = k1 - 1; n2 <= n1 - 1; n2++) {
                            sum = (sum + dp[n2 - 1][m2 - 1][k1 - 2] * BigInteger.valueOf(m2).modPow(BigInteger.valueOf(n1 - n2 - 1), bigP).intValue()) % p;
                        }
                    }
                    dp[n1 - 1][m1 - 1][k1 - 1] = sum;
                }
            }
        }
        long ans = 0;
        for (int n1 = 0; n1 < n; n1++) {
            for (int m1 = 0; m1 < m; m1++) {
                ans = (ans + dp[n1][m1][k - 1] * BigInteger.valueOf(m1 + 1).modPow(BigInteger.valueOf(n - n1 - 1), bigP).intValue()) % p;
            }
        }
        return (int) ans;
    }
}
