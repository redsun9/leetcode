package leetcode.leetcode16xx.leetcode1621;

import java.math.BigInteger;

public class Solution {
    //c(n+k-1,2k)
    public static final int p = 1_000_000_007;
    public static final BigInteger bigP = BigInteger.valueOf(p);

    public int numberOfSets(int n, int k) {
        int a1 = n + k - 1;
        int b = 2 * k;
        int c = n - k - 1;
        int a2 = Math.min(b, c);
        int a3 = Math.max(b, c);
        long tmp = 1;
        for (int i = 1; i <= a2; i++) tmp = tmp * i % p;
        int fact2 = (int) tmp;
        for (int i = a2 + 1; i <= a3; i++) tmp = tmp * i % p;
        int fact3 = (int) tmp;
        for (int i = a3 + 1; i <= a1; i++) tmp = tmp * i % p;
        int fact1 = (int) tmp;

        return BigInteger.valueOf(fact1)
                .multiply(BigInteger.valueOf(fact2).modInverse(bigP))
                .multiply(BigInteger.valueOf(fact3).modInverse(bigP))
                .mod(bigP)
                .intValue();
    }
}
