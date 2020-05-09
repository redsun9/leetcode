package leetcode.leetcode9xx.leetcode963;

public class Solution implements MinAreaRectFinder {
    public double minAreaFreeRect(int[][] points) {
        int n = points.length;
        if (n < 4) return 0;
        int ans = Integer.MAX_VALUE;
        boolean foundRect = false;
        for (int i = 0; i < n - 3; i++) {
            int[] a = points[i];
            for (int j = i + 1; j < n - 2; j++) {
                int[] b = points[j];
                for (int k = j + 1; k < n - 1; k++) {
                    int[] c = points[k];
                    for (int l = k + 1; l < n; l++) {
                        int[] d = points[l];
                        //проверяем три случая
                        //1. a-b противоположные
                        //2. a-c противоположные
                        //3. a-d противоположные
                        if (
                                a[0] + b[0] == c[0] + d[0] && //середины диагоналей совпадают
                                        a[1] + b[1] == c[1] + d[1] &&
                                        (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1])
                                                == (c[0] - d[0]) * (c[0] - d[0]) + (c[1] - d[1]) * (c[1] - d[1]) ||
                                        a[0] + c[0] == b[0] + d[0] && //середины диагоналей совпадают
                                                a[1] + c[1] == b[1] + d[1] &&
                                                (a[0] - c[0]) * (a[0] - c[0]) + (a[1] - c[1]) * (a[1] - c[1])
                                                        == (b[0] - d[0]) * (b[0] - d[0]) + (b[1] - d[1]) * (b[1] - d[1]) ||
                                        a[0] + d[0] == c[0] + b[0] && //середины диагоналей совпадают
                                                a[1] + d[1] == c[1] + b[1] &&
                                                (a[0] - d[0]) * (a[0] - d[0]) + (a[1] - d[1]) * (a[1] - d[1])
                                                        == (c[0] - b[0]) * (c[0] - b[0]) + (c[1] - b[1]) * (c[1] - b[1])
                        ) {
                            foundRect = true;
                            int s = Math.abs((b[0] - a[0]) * (c[1] - a[1]) - (b[1] - a[1]) * (c[0] - a[0]));
                            ans = Math.min(ans, s);
                        }
                    }
                }
            }
        }
        return foundRect ? ans : 0;
    }
}
