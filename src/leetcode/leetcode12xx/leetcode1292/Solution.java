package leetcode.leetcode12xx.leetcode1292;

public class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        long[][] sum = new long[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i + 1][j + 1] = mat[i][j] + sum[i + 1][j] + sum[i][j + 1] - sum[i][j];
            }
        }
        for (int d = Math.min(m, n); d > 0; d--) {
            for (int i1 = d, i2 = 0; i1 <= m; i1++, i2++) {
                for (int j1 = d, j2 = 0; j1 <= n; j1++, j2++) {
                    if (sum[i1][j1] - sum[i2][j1] - sum[i1][j2] + sum[i2][j2] <= threshold) return d;
                }
            }
        }
        return 0;
    }
}
