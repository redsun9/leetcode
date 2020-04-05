package leetcode.leetcode13xx.leetcode1359;

import java.math.BigInteger;

public class Solution {
    private static final long m = 1_000_000_007;
    private static final BigInteger bigM = BigInteger.valueOf(m);
    private static final BigInteger reverse2 = BigInteger.valueOf(2).modInverse(bigM);
    ;

    public int countOrders(int n) {
        long ans = 2;
        for (int i = 2, j = 3; i <= n; i++, j += 2) {
            ans = ans * j * (j + 1) % m;
        }
        return (int) (ans * reverse2.modPow(BigInteger.valueOf(n), bigM).intValue() % m);
    }
}
