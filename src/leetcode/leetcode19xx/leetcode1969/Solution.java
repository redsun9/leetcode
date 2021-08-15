package leetcode.leetcode19xx.leetcode1969;

@SuppressWarnings("DuplicatedCode")
public class Solution {
    private static final int m = 1_000_000_007;

    public int minNonZeroProduct(int p) {
        long a = (1L << p) - 1;
        long b = (1L << p) - 2, powB = ((1L << p) - 2) / 2;
        return (int) (a % m * powMod(b % m, powB) % m);
    }

    private static long powMod(long a, long b) {
        long res = 1;
        while (b != 0)
            if ((b & 1) != 0) {
                res = (res * a) % m;
                --b;
            } else {
                a = (int) ((a * a) % m);
                b >>= 1;
            }
        if (res < 0) res += m;
        return res;
    }
}
