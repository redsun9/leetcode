package leetcode.leetcode23xx.leetcode2320;

public class Solution {
    private static final int p = 1_000_000_007;

    public int countHousePlacements(int n) {
        if (n == 1) return 4;
        if (n == 2) return 9;
        long[][] matrix = {{0, 1}, {1, 1}};
        long[][] power = matrixPower(matrix, n - 1);
        int ans = 0;
        for (long[] row : power) {
            for (long a : row) {
                ans += a;
                if (ans >= p) ans -= p;
            }
        }
        return (int) ((long) ans * ans % p);
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
                    if (ans[i][j] >= p) ans[i][j] %= p; // remove if not modular
                }
            }
        }
        return ans;
    }
}
