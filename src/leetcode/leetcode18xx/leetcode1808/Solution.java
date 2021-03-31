package leetcode.leetcode18xx.leetcode1808;

public class Solution {
    private static final int p = 1_000_000_007;

    private static long powMod(long a, long b) {
        long res = 1;
        while (b != 0)
            if ((b & 1) != 0) {
                res = (res * a) % p;
                --b;
            } else {
                a = (a * a) % p;
                b >>= 1;
            }
        return res;
    }

    public int maxNiceDivisors(int primeFactors) {
        int numberOfThrees = primeFactors / 3;
        int numberOfTwos = 0;
        int mod = primeFactors % 3;
        if (mod == 1 && numberOfThrees != 0) {
            numberOfThrees--;
            numberOfTwos = 2;
        } else if (mod == 2) {
            numberOfTwos = 1;
        }
        return (int) (powMod(2, numberOfTwos) * powMod(3, numberOfThrees) % p);
    }
}
