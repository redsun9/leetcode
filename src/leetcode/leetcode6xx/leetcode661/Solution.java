package leetcode.leetcode6xx.leetcode661;

public class Solution {
    public int[][] imageSmoother(int[][] a) {
        int m = a.length;
        int n = a[0].length;

        for (int h = -1; h <= 1; h++) {
            for (int i = Math.max(0, -h); i < Math.min(m, m - h); i++) {
                for (int w = -1; w <= 1; w++) {
                    for (int j = Math.max(0, -w); j < Math.min(n, n - w); j++) {
                        a[i + h][j + w] += (a[i][j] & 0xFF) << 8;
                        a[i + h][j + w] += 1 << 24;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = ((a[i][j] >> 8) & 0xFFFF) / (a[i][j] >> 24);
            }
        }
        return a;
    }
}
