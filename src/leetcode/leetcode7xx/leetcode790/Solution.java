package leetcode.leetcode7xx.leetcode790;

@SuppressWarnings("DuplicatedCode")
public class Solution {
    private static final int p = 1_000_000_007;
    private static final long[][] mat = {{1, 1, 0, 1}, {1, 0, 0, 0}, {2, 0, 1, 0}, {0, 0, 1, 0}};

    public int numTilings(int n) {
        return (int) matrixPower(n)[0][0];
    }

    private static long[][] matrixPower(long pow) {
        long[][] base = mat;
        long[][] res = new long[4][4];
        for (int i = 0; i < 4; i++) {
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
        long[][] ans = new long[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    ans[i][j] += a[i][k] * b[k][j];
                    if (ans[i][j] >= p) ans[i][j] %= p;
                }
            }
        }
        return ans;
    }
}
