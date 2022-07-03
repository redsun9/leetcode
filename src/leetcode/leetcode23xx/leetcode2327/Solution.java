package leetcode.leetcode23xx.leetcode2327;

import java.util.Arrays;

// O(forget^3 * logN)
public class Solution {
    private static final int p = 1_000_000_007;

    private static long[][] matrixPower(long[][] base, long pow) {
        int n = base.length;
        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++) res[i][i] = 1;
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
                    if (ans[i][j] >= p) ans[i][j] %= p; // remove if not modular
                }
            }
        }
        return ans;
    }

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[][] mat = new long[forget][forget];
        Arrays.fill(mat[0], delay - 1, forget - 1, 1);
        for (int i = 1; i < forget; i++) mat[i][i - 1] = 1;
        long[][] power = matrixPower(mat, n - 1);
        int ans = 0;
        for (int i = 0; i < forget; i++) {
            ans += power[i][0];
            if (ans >= p) ans -= p;
        }
        return ans;
    }
}
