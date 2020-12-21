package leetcode.leetcode16xx.leetcode1646;

public class Solution {
    public int getMaximumGenerated(int n) {
        int[] a = new int[101];
        a[1] = 1;
        for (int i = 2; i <= 100; i++) {
            a[i] = a[i >> 1];
            if ((i & 1) != 0) a[i] += a[(i >> 1) + 1];
        }
        for (int i = 1; i <= 100; i++) {
            a[i] = Math.max(a[i], a[i - 1]);
        }
        return a[n];
    }
}
