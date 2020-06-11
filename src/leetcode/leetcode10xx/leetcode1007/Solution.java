package leetcode.leetcode10xx.leetcode1007;

public class Solution {
    public int minDominoRotations(int[] a, int[] b) {
        int n = a.length;
        int ans1 = 0, ans2 = 0, val1 = a[0], val2 = b[0], doubles = 0;
        for (int i = 0; i < n && (ans1 != -1 || ans2 != -1); i++) {
            if (a[i] == b[i]) doubles++;
            if (ans1 != -1) {
                if (a[i] != val1) {
                    if (b[i] != val1) ans1 = -1;
                    else ans1++;
                }
            }
            if (ans2 != -1) {
                if (b[i] != val2) {
                    if (a[i] != val2) ans2 = -1;
                    else ans2++;
                }
            }
        }
        if (ans1 == -1 && ans2 == -1) return -1;
        int min1 = Math.min(ans1, n - doubles - ans1);
        int min2 = Math.min(ans2, n - doubles - ans2);
        if (ans2 == -1) return min1;
        if (ans1 == -1) return min2;
        return Math.min(min1, min2);
    }
}
