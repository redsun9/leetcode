package leetcode.leetcode26xx.leetcode2614;

@SuppressWarnings("DuplicatedCode")
public class Solution {
    public int diagonalPrime(int[][] nums) {
        int n = nums.length;
        int ans = 1;
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            if (nums[i][i] > ans && isPrime(nums[i][i])) ans = nums[i][i];
            if (nums[i][j] > ans && isPrime(nums[i][j])) ans = nums[i][j];
        }
        return ans != 1 ? ans : 0;
    }

    private static final int[] factors = {2, 3, 5, 7}; // n < 3_215_031_751
    private final int[] p = {2, 3, 5, 7};

    private final int trivial_limit = p.length;

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

    private boolean isPrime(int n) {
        for (int i = 0; i < trivial_limit && p[i] < n; ++i)
            if (n % p[i] == 0)
                return false;
        if (p[trivial_limit - 1] * p[trivial_limit - 1] >= n)
            return true;
        return millerRabin(n);
    }

    private boolean millerRabin(int n) {
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

    private boolean millerRabinRound(int a, int d, int n, int r) {
        int x = powMod(a, d, n);
        if (x == 1 || x == n - 1) return true;
        for (int i = 1; i < r; i++) {
            x = (int) ((long) x * x % n);
            if (x == n - 1) return true;
        }
        return false;
    }
}
