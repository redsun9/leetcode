package leetcode.leetcode3xx.leetcode304;

public class NumMatrix {
    private final int[][] a;

    public NumMatrix(int[][] t) {
        int m = t.length;
        int n = t[0].length;
        this.a = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                this.a[i + 1][j + 1] = this.a[i + 1][j] + this.a[i][j + 1] - this.a[i][j] + t[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return a[row2 + 1][col2 + 1] - a[row1][col2 + 1] - a[row2 + 1][col1] + a[row1][col1];
    }
}
