package leetcode.leetcode3xx.leetcode304;

public class NumMatrix2 {
    private final int[][] a;

    public NumMatrix2(int[][] a) {
        this.a = a;
        int[] prev, next = a[0];
        int m = a.length, n = next.length;
        for (int i = 1; i < n; i++) next[i] += next[i - 1];
        for (int j = 1; j < m; j++) a[j][0] += a[j - 1][0];
        for (int i = 1; i < m; i++) {
            prev = next;
            next = a[i];
            for (int j = 1; j < n; j++) next[j] += prev[j] + next[j - 1] - prev[j - 1];
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0) return a[row2][col2];
        if (row1 == 0) return a[row2][col2] - a[row2][col1 - 1];
        if (col1 == 0) return a[row2][col2] - a[row1 - 1][col2];
        return a[row2][col2] - a[row1 - 1][col2] - a[row2][col1 - 1] + a[row1 - 1][col1 - 1];
    }
}
