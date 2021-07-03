package leetcode.leetcode8xx.leetcode870;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int[] advantageCount(int[] a, int[] b) {
        int n = a.length;
        Arrays.sort(a);
        int[][] c = new int[n][2];
        for (int i = 0; i < n; i++) {
            c[i][0] = b[i];
            c[i][1] = i;
        }
        Arrays.sort(c, Comparator.comparingInt(x -> x[0]));
        for (int i = 0, l = 0, r = n - 1; i < n; i++) {
            if (a[i] > c[l][0]) b[c[l++][1]] = a[i];
            else b[c[r--][1]] = a[i];
        }
        return b;
    }
}
