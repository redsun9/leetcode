package leetcode.leetcode14xx.leetcode1458;

import java.util.Arrays;

public class Solution {
    public int maxDotProduct(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];
        curr[0] = Integer.MIN_VALUE;
        Arrays.fill(prev, Integer.MIN_VALUE);
        for (int value : a) {
            for (int j = 0; j < n; j++) {
                curr[j + 1] = max(value * b[j] + Math.max(prev[j], 0), prev[j + 1], curr[j]);
            }
            int[] tmp = curr;
            curr = prev;
            prev = tmp;
        }
        return prev[n];
    }

    private static int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }
}
