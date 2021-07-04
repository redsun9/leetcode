package leetcode.leetcode19xx.leetcode1922;

public class Solution {
    public static final int p = 1_000_000_007;

    private static long powMod(long a, long b) {
        long res = 1;
        while (b != 0)
            if ((b & 1) != 0) {
                res = res * a % p;
                --b;
            } else {
                a = a * a % p;
                b >>= 1;
            }
        return res;
    }

    public int countGoodNumbers(long n) {
        long even = (n - 1) / 2;
        long odd = n / 2;
        return (int) (powMod(5, even) * powMod(4, odd) % p);
    }
}
