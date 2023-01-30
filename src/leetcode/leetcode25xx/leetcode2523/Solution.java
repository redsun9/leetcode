package leetcode.leetcode25xx.leetcode2523;

@SuppressWarnings("DuplicatedCode")
public class Solution {
    public int[] closestPrimes(int left, int right) {
        int[] ans = {-1, -1};
        int minDiff = Integer.MAX_VALUE;

        int prevPrime = -1;
        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                if (prevPrime != -1) {
                    int diff = i - prevPrime;
                    if (diff < minDiff) {
                        minDiff = diff;
                        ans[0] = prevPrime;
                        ans[1] = i;
                    }
                }
                prevPrime = i;
            }
        }
        return ans;
    }

    private static final int[] factors = {2, 3}; // n < 1_373_653
    private final int[] primes = {2, 3, 5, 7, 11};

    private static int powMod(int a, int b, int m) {
        int res = 1;
        while (b != 0) {
            if ((b & 1) == 1) {
                res = (int) (((long) res * a) % m);
                b--;
            } else {
                a = (int) (((long) a * a) % m);
                b >>= 1;
            }
        }
        return res;
    }

    public boolean isPrime(int n) {
        if (n <= 12) return n == 2 || n == 3 || n == 5 || n == 7 || n == 11;
        for (int p : primes) if (n % p == 0) return false;
        if (n <= 121) return true;
        return millerRabin(n);
    }

    private static boolean millerRabin(int n) {
        int d = n - 1;
        int r = 0;
        while ((d & 1) == 0) {
            r++;
            d >>= 1;
        }
        for (int factor : factors) {
            if (!millerRabinRound(factor, d, n, r)) return false;
        }
        return true;
    }

    private static boolean millerRabinRound(int a, int d, int n, int r) {
        int x = powMod(a, d, n);
        if (x == 1 || x == n - 1) return true;
        for (int i = 1; i < r; i++) {
            x = (int) ((long) x * x % n);
            if (x == n - 1) return true;
        }
        return false;
    }
}
