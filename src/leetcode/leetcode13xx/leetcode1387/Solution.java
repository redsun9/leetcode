package leetcode.leetcode13xx.leetcode1387;

public class Solution {
    public int getKth(int lo, int hi, int k) {
        if (lo == 1 && k == 1) return 1;
        if (lo == 1) k--;
        int n = hi - lo + 1;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = lo + i;
        }
        while (true) {
            for (int i = 0; i < n; i++) {
                if (a[i] == 1) continue;
                if ((a[i] & 1) == 0) {
                    a[i] /= 2;
                    if (a[i] == 1) {
                        k--;
                        if (k == 0) return lo + i;
                    }
                } else a[i] = 3 * a[i] + 1;
            }
        }
    }
}
