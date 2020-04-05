package leetcode.leetcode2xx.leetcode264;

import java.util.Arrays;

public class Solution {
    private static final int max2 = Integer.MAX_VALUE / 2;
    private static final int max3 = Integer.MAX_VALUE / 3;
    private static final int max5 = Integer.MAX_VALUE / 5;

    public int nthUglyNumber(int n) {
        int[] a = new int[n];
        a[0] = 1;
        int i = 0;
        int j = 1;
        while (i < n - 1) {
            if (a[i] <= max2) {
                int pos = Arrays.binarySearch(a, i + 1, j, a[i] * 2);
                if (pos < 0) {
                    pos = -pos - 1;
                    if (pos != n) {
                        for (int k = Math.min(n - 2, j - 1); k >= pos; k--) {
                            a[k + 1] = a[k];
                        }
                        a[pos] = a[i] * 2;
                        j = Math.min(j + 1, n);
                    }
                }
            }
            if (a[i] <= max3) {
                int pos = Arrays.binarySearch(a, i + 1, j, a[i] * 3);
                if (pos < 0) {
                    pos = -pos - 1;
                    if (pos != n) {
                        for (int k = Math.min(n - 2, j - 1); k >= pos; k--) {
                            a[k + 1] = a[k];
                        }
                        a[pos] = a[i] * 3;
                        j = Math.min(j + 1, n);
                    }
                }
            }
            if (a[i] <= max5) {
                int pos = Arrays.binarySearch(a, i + 1, j, a[i] * 5);
                if (pos < 0) {
                    pos = -pos - 1;
                    if (pos != n) {
                        for (int k = Math.min(n - 2, j - 1); k >= pos; k--) {
                            a[k + 1] = a[k];
                        }
                        a[pos] = a[i] * 5;
                        j = Math.min(j + 1, n);
                    }
                }
            }
            i++;
        }
        return a[n - 1];
    }
}
