package basic.matrix;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

//only square matrix
public class MatrixTools {
    private static final int STRASSEN_THRESHOLD = 100;
    static final int p = 1_000_000_007;

    public static long[][] matrixPower(long[][] base, long pow) {
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

    public static long[][] multiplyMatrix(long[][] a, long[][] b) {
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

    public static long[][] multiplyMatrixParallel(long[][] a, long[][] b) {
        int n = a.length;
        long[][] ans = new long[n][n];
        IntStream.range(0, n).parallel().forEach(i ->
                IntStream.range(0, n).parallel().forEach(j -> {
                    long tmp = 0;
                    for (int k = 0; k < n; k++) {
                        tmp += a[i][k] * b[k][j];
                        if (tmp >= p) tmp %= p; // remove if not modular
                    }
                    ans[i][j] = tmp;
                })
        );
        return ans;
    }

    public static long[][] multiStrassen(long[][] a, long[][] b) {
        int n = a.length;
        if (n <= STRASSEN_THRESHOLD) return multiplyMatrix(a, b);
        long[][] bt = new long[n][n];
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) bt[i][j] = b[j][i];
        return strassen(a, bt);
    }

    public static long[][] multiStrassenParallel(long[][] a, long[][] b) {
        int n = a.length;
        if (n <= STRASSEN_THRESHOLD) return multiplyMatrixParallel(a, b);
        long[][] bt = new long[n][n];
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) bt[i][j] = b[j][i];
        return new MyRecursiveTask(a, bt).fork().join();
    }

    private static long[][] multiplyTransposedMatrix(long[][] a, long[][] b) {
        int n = a.length;
        long[][] c = new long[n][n];
        long tmp;
        for (int i = 0; i < n; i++) {
            long[] rowA = a[i];
            long[] rowC = c[i];
            for (int j = 0; j < n; j++) {
                long[] rowB = b[j];
                tmp = 0;
                for (int k = 0; k < n; k++) {
                    tmp += rowA[k] * rowB[k];
                    if (tmp >= p) tmp %= p; // remove if not modular
                }
                rowC[j] = tmp;
            }
        }
        return c;
    }


    private static long[][] strassen(long[][] a, long[][] b) {
        int n = a.length;
        if (n <= STRASSEN_THRESHOLD) return multiplyTransposedMatrix(a, b);

        int m = (n + 1) >>> 1;

        long[][] a11 = new long[m][m];
        long[][] a12 = new long[m][m];
        long[][] a21 = new long[m][m];
        long[][] a22 = new long[m][m];

        long[][] b11 = new long[m][m];
        long[][] b12 = new long[m][m];
        long[][] b21 = new long[m][m];
        long[][] b22 = new long[m][m];

        splitMatrix(a, a11, a12, a21, a22);
        splitMatrix(b, b11, b12, b21, b22);

        long[][] p1 = strassen(summation(a11, a22), summation(b11, b22));
        long[][] p2 = strassen(summation(a21, a22), b11);
        long[][] p3 = strassen(a11, subtraction(b21, b22));
        long[][] p4 = strassen(a22, subtraction(b12, b11));
        long[][] p5 = strassen(summation(a11, a12), b22);
        long[][] p6 = strassen(subtraction(a21, a11), summation(b11, b21));
        long[][] p7 = strassen(subtraction(a12, a22), summation(b12, b22));

        long[][] c11 = calculateC11(p1, p4, p5, p7);
        long[][] c12 = summation(p3, p5);
        long[][] c21 = summation(p2, p4);
        long[][] c22 = calculateC22(p1, p2, p3, p6);

        return collectMatrix(c11, c12, c21, c22, n);
    }

    private static void splitMatrix(long[][] a, long[][] a11, long[][] a12, long[][] a21, long[][] a22) {
        int n = a.length;
        if ((n & 1) == 0) {
            n >>>= 1;
            for (int i = 0, j = n; i < n; i++, j++) {
                System.arraycopy(a[i], 0, a11[i], 0, n);
                System.arraycopy(a[i], n, a12[i], 0, n);
                System.arraycopy(a[j], 0, a21[i], 0, n);
                System.arraycopy(a[j], n, a22[i], 0, n);
            }
        } else {
            int n1 = (n + 1) >>> 1;
            int n2 = n >>> 1;
            for (int i = 0, j = n1; i < n2; i++, j++) {
                System.arraycopy(a[i], 0, a11[i], 0, n1);
                System.arraycopy(a[i], n1, a12[i], 0, n2);
                System.arraycopy(a[j], 0, a21[i], 0, n1);
                System.arraycopy(a[j], n1, a22[i], 0, n2);
            }
            System.arraycopy(a[n2], 0, a11[n2], 0, n1);
            System.arraycopy(a[n2], n1, a12[n2], 0, n2);
        }
    }

    private static long[][] collectMatrix(long[][] a11, long[][] a12, long[][] a21, long[][] a22, int n) {
        long[][] a = new long[n][n];
        if ((n & 1) == 0) {
            n >>>= 1;
            for (int i = 0, j = n; i < n; i++, j++) {
                System.arraycopy(a11[i], 0, a[i], 0, n);
                System.arraycopy(a12[i], 0, a[i], n, n);
                System.arraycopy(a21[i], 0, a[j], 0, n);
                System.arraycopy(a22[i], 0, a[j], n, n);
            }
        } else {
            int n1 = (n + 1) >>> 1;
            int n2 = n >>> 1;
            for (int i = 0, j = n1; i < n2; i++, j++) {
                System.arraycopy(a11[i], 0, a[i], 0, n1);
                System.arraycopy(a12[i], 0, a[i], n1, n2);
                System.arraycopy(a21[i], 0, a[j], 0, n1);
                System.arraycopy(a22[i], 0, a[j], n1, n2);
            }
            System.arraycopy(a11[n2], 0, a[n2], 0, n1);
            System.arraycopy(a12[n2], 0, a[n2], n1, n2);
        }
        return a;
    }

    private static long[][] summation(long[][] aMat, long[][] bMat) {
        int n = aMat.length;
        long[][] cMat = new long[n][n];
        long tmp;
        for (int i = 0; i < n; i++) {
            long[] cRow = cMat[i];
            long[] aRow = aMat[i];
            long[] bRow = bMat[i];
            for (int j = 0; j < n; j++) {
                tmp = aRow[j] + bRow[j];
                if (tmp >= p) tmp -= p; // remove if not modular
                cRow[j] = tmp;
            }
        }
        return cMat;
    }

    private static long[][] subtraction(long[][] aMat, long[][] bMat) {
        int n = aMat.length;
        long[][] cMat = new long[n][n];
        long tmp;
        for (int i = 0; i < n; i++) {
            long[] cRow = cMat[i];
            long[] aRow = aMat[i];
            long[] bRow = bMat[i];
            for (int j = 0; j < n; j++) {
                tmp = aRow[j] - bRow[j];
                if (tmp < 0) tmp += p; // remove if not modular
                cRow[j] = tmp;
            }
        }
        return cMat;
    }

    private static long[][] calculateC11(long[][] p1, long[][] p4, long[][] p5, long[][] p7) {
        int n = p1.length;
        long[][] c11 = new long[n][n];
        long tmp;
        for (int i = 0; i < n; i++) {
            long[] c11Row = c11[i];
            long[] p1Row = p1[i];
            long[] p4Row = p4[i];
            long[] p5Row = p5[i];
            long[] p7Row = p7[i];

            for (int j = 0; j < n; j++) {
                tmp = p1Row[j] + p4Row[j] - p5Row[j];
                if (tmp >= p) tmp -= p; // remove if not modular
                tmp += p7Row[j];
                if (tmp >= p) tmp -= p; // remove if not modular
                else if (tmp < 0) tmp += p;
                c11Row[j] = tmp;
            }
        }
        return c11;
    }

    private static long[][] calculateC22(long[][] p1, long[][] p2, long[][] p3, long[][] p6) {
        int n = p1.length;
        long[][] c22 = new long[n][n];
        long tmp;
        for (int i = 0; i < n; i++) {
            long[] c22Row = c22[i];
            long[] p1Row = p1[i];
            long[] p2Row = p2[i];
            long[] p3Row = p3[i];
            long[] p6Row = p6[i];

            for (int j = 0; j < n; j++) {
                tmp = p1Row[j] + p3Row[j] - p2Row[j];
                if (tmp >= p) tmp -= p; // remove if not modular
                tmp += p6Row[j];
                if (tmp >= p) tmp -= p; // remove if not modular
                else if (tmp < 0) tmp += p;
                c22Row[j] = tmp;
            }
        }
        return c22;
    }

    private static class MyRecursiveTask extends RecursiveTask<long[][]> {
        private final long[][] a;
        private final long[][] b;

        public MyRecursiveTask(long[][] a, long[][] b) {
            this.a = a;
            this.b = b;
        }

        @Override
        protected long[][] compute() {
            int n = a.length;
            if (n <= STRASSEN_THRESHOLD) return multiplyTransposedMatrix(a, b);

            int m = (n + 1) >>> 1;

            long[][] a11 = new long[m][m];
            long[][] a12 = new long[m][m];
            long[][] a21 = new long[m][m];
            long[][] a22 = new long[m][m];

            long[][] b11 = new long[m][m];
            long[][] b12 = new long[m][m];
            long[][] b21 = new long[m][m];
            long[][] b22 = new long[m][m];

            splitMatrix(a, a11, a12, a21, a22);
            splitMatrix(b, b11, b12, b21, b22);

            ForkJoinTask<long[][]> taskP1 = new MyRecursiveTask(summation(a11, a22), summation(b11, b22)).fork();
            ForkJoinTask<long[][]> taskP2 = new MyRecursiveTask(summation(a21, a22), b11).fork();
            ForkJoinTask<long[][]> taskP3 = new MyRecursiveTask(a11, subtraction(b21, b22)).fork();
            ForkJoinTask<long[][]> taskP4 = new MyRecursiveTask(a22, subtraction(b12, b11)).fork();
            ForkJoinTask<long[][]> taskP5 = new MyRecursiveTask(summation(a11, a12), b22).fork();
            ForkJoinTask<long[][]> taskP6 = new MyRecursiveTask(subtraction(a21, a11), summation(b11, b21)).fork();
            ForkJoinTask<long[][]> taskP7 = new MyRecursiveTask(subtraction(a12, a22), summation(b12, b22)).fork();

            long[][] p1 = taskP1.join();
            long[][] p2 = taskP2.join();
            long[][] p3 = taskP3.join();
            long[][] p4 = taskP4.join();
            long[][] p5 = taskP5.join();
            long[][] p6 = taskP6.join();
            long[][] p7 = taskP7.join();

            long[][] c11 = calculateC11(p1, p4, p5, p7);
            long[][] c12 = summation(p3, p5);
            long[][] c21 = summation(p2, p4);
            long[][] c22 = calculateC22(p1, p2, p3, p6);

            return collectMatrix(c11, c12, c21, c22, n);
        }
    }
}
