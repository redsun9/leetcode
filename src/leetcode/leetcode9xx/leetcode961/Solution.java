package leetcode.leetcode9xx.leetcode961;

public class Solution {
    public int repeatedNTimes(int[] a) {
        int n = a.length;
        for (int i = 0, j = 4; j <= n; i += 4, j += 4) {
            for (int k = i; k < j - 1; k++) {
                for (int l = k + 1; l < j; l++) {
                    if (a[k] == a[l]) return a[k];
                }
            }
        }
        return a[n - 1];
    }
}
