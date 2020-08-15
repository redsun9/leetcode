package leetcode.leetcode8xx.leetcode896;

public class Solution {
    public boolean isMonotonic(int[] a) {
        int n = a.length;
        if (n <= 2) return true;
        boolean ok = true;
        for (int i = 1; i < n; i++) {
            if (a[i] < a[i - 1]) {
                ok = false;
                break;
            }
        }
        if (ok) return true;
        for (int i = 1; i < n; i++) if (a[i] > a[i - 1]) return false;
        return true;
    }
}
