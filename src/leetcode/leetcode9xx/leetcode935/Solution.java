package leetcode.leetcode9xx.leetcode935;

@SuppressWarnings("DuplicatedCode")
public class Solution {
    private static final int p = 1_000_000_007;

    public int knightDialer(int n) {
        long[][] matrix = new long[10][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (Math.abs(i / 3 - j / 3) * Math.abs(i % 3 - j % 3) == 2) matrix[i][j] = 1;
            }
        }
        matrix[3][9] = 1;
        matrix[9][3] = 1;
        matrix[5][9] = 1;
        matrix[9][5] = 1;

        long[][] pow = matrixPower(matrix, n - 1);
        long ans = 0;
        for (long[] row : pow) for (long a : row) ans += a;
        return (int) (ans % p);
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
                    if (ans[i][j] >= p) ans[i][j] %= p;
                }
            }
        }
        return ans;
    }
}
