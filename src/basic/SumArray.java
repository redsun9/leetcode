package basic;

public class SumArray {
    public static class SumArray1d {
        private final int[] a;

        public SumArray1d(int[] t) {
            int n = t.length;
            a = new int[n + 1];
            for (int i = 0; i < n; i++) {
                a[i + 1] = a[i] + t[i];
            }
        }

        // sum [startPos,endPos)
        // [i;i) = 0
        // [0;n) - sum all
        public int sumSegment(int startPos, int endPos) {
            return a[endPos] - a[startPos];
        }
    }

    public static class SumArray2d {
        private final int[][] a;

        public SumArray2d(int[][] t) {
            int m = t.length;
            int n = t[0].length;
            this.a = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    this.a[i + 1][j + 1] = this.a[i + 1][j] + this.a[i][j + 1] - this.a[i][j] + t[i][j];
                }
            }
        }

        // sum [startN,endN)x[startM.endM)
        // startN==endN => 0
        // startM==endM => 0
        // [0,n)x[0,m) - sum all
        public int sumSegment(int startN, int endN, int startM, int endM) {
            return a[endN][endM] - a[startN][endM] - a[endN][startM] + a[startN][startM];
        }
    }

    public static class SumArray3d {
        private final int[][][] a;

        public SumArray3d(int[][][] t) {
            int m = t.length;
            int n = t[0].length;
            int k = t[0][0].length;
            a = new int[m + 1][n + 1][k + 1];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int p = 0; p < k; p++) {
                        a[i + 1][j + 1][p + 1] = a[i][j + 1][p + 1] + a[i + 1][j][p + 1] + a[i + 1][j + 1][p]
                                - a[i + 1][j][p] - a[i][j + 1][p] - a[i][j][p + 1] + a[i][j][p] + t[i][j][p];
                    }
                }
            }
        }

        // sum [startN,endN)x[startM.endM)
        // startN==endN => 0
        // startM==endM => 0
        // [0,m)x[0,n)x[0,k) - sum all
        public int sumSegment(int startI, int endI, int startJ, int endJ, int startK, int endK) {
            return a[endI][endJ][endK] - a[startI][endJ][endK] - a[endI][startJ][endK] - a[endI][endJ][startK]
                    + a[startI][startJ][endK] + a[startI][endJ][startK] + a[endI][startJ][startK] - a[startI][startJ][startK];
        }
    }
}
