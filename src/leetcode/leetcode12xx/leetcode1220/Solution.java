package leetcode.leetcode12xx.leetcode1220;

public class Solution {
    public static final int mod = 1_000_000_007;
    private static final long[][] mat = {
            {0, 1, 1, 0, 1},
            {1, 0, 1, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 1, 0}
    };

    public int countVowelPermutation(int n) {
        long[][] p = matrixPower(mat, n - 1);
        long ans = 0;
        for (long[] a : p) {
            for (long b : a) {
                ans += b;
            }
        }
        return (int) (ans % mod);
    }

    private static long[][] matrixPower(long[][] base, long pow) {
        int n = base.length;
        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++) {
            res[i][i] = 1;
        }
        while (pow != 0) {
            if ((pow & 1) != 0) {
                res = multiplyMatrix(res, base);
                --pow;
            } else {
                base = multiplyMatrix(base, base);
                pow >>= 1;
            }
        }
        return res;
    }

    private static long[][] multiplyMatrix(long[][] a, long[][] b) {
        int n = a.length;
        long[][] ans = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    ans[i][j] += a[i][k] * b[k][j];
                }
                ans[i][j] %= mod;
            }
        }
        return ans;
    }
}
