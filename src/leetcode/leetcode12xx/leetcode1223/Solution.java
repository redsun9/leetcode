package leetcode.leetcode12xx.leetcode1223;

import java.util.Arrays;

@SuppressWarnings("DuplicatedCode")
public class Solution {
    private static final int p = 1_000_000_007;

    public int dieSimulator(int n, int[] rollMax) {
        int[] prefSum = new int[7];
        for (int i = 0; i < 6; i++) prefSum[i + 1] = prefSum[i] + rollMax[i];
        int matSize = prefSum[6];
        long[][] mat = new long[matSize][matSize];
        for (int i = 0; i < 6; i++) {
            Arrays.fill(mat[prefSum[i]], 1);
            Arrays.fill(mat[prefSum[i]], prefSum[i], prefSum[i + 1], 0);
            for (int k = rollMax[i], j = prefSum[i + 1] - 1; k > 1; j--, k--) mat[j][j - 1] = 1;
        }
        long[][] res = matrixPower(mat, n - 1);
        int ans = 0;
        for (long[] re : res) {
            for (int i = 0; i < 6; i++) {
                ans += re[prefSum[i]];
                if (ans >= p) ans -= p;
            }
        }
        return ans;
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
