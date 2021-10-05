package leetcode.leetcode3xx.leetcode308;

public class NumMatrix {
    private final int[][] a;
    private final int m, n;


    public NumMatrix(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        this.m = nextPow2(row);
        this.n = nextPow2(col);
        this.a = new int[m << 1][n << 1];

        for (int i1 = 0, i2 = m; i1 < row; i1++, i2++) System.arraycopy(matrix[i1], 0, a[i2], n, col);

        for (int i = m - 1; i >= 1; i--) {
            for (int j = n * 2 - 1; j >= n; j--) {
                a[i][j] = a[i << 1][j] + a[i << 1 | 1][j];
            }
        }


        for (int i = m * 2 - 1; i >= 1; i--) {
            for (int j = n - 1; j >= 0; j--) {
                a[i][j] = a[i][j << 1] + a[i][j << 1 | 1];
            }
        }
    }

    public void update(int row, int col, int val) {
        int diff = val - a[m + row][n + col];
        int i = m + row;
        while (i != 0) {
            int j = n + col;
            while (j != 0) {
                a[i][j] += diff;
                j = j >>> 1;
            }
            i = i >>> 1;
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumRegion(1, 1, 0, m, 0, n, row1, row2 + 1, col1, col2 + 1);
    }

    private int sumRegion(int i, int j, int l, int r, int b, int t, int ql, int qr, int qb, int qt) {
        if (l >= qr || r <= ql || b >= qt || t <= qb) return 0;
        if (ql <= l && r <= qr && qb <= b && t <= qt) return a[i][j];

        if (ql > l || r > qr) {
            int midI = (l + r) >>> 1;
            return sumRegion(i << 1, j, l, midI, b, t, ql, qr, qb, qt) +
                    sumRegion(i << 1 | 1, j, midI, r, b, t, ql, qr, qb, qt);
        } else {
            int midJ = (b + t) >>> 1;
            return sumRegion(i, j << 1, l, r, b, midJ, ql, qr, qb, qt) +
                    sumRegion(i, j << 1 | 1, l, r, midJ, t, ql, qr, qb, qt);
        }
    }

    private static int nextPow2(int n) {
        if ((n & (n - 1)) == 0) return n;
        else return Integer.highestOneBit(n) << 1;
    }
}
