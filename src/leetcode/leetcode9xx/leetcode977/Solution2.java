package leetcode.leetcode9xx.leetcode977;

public class Solution2 {
    public int[] sortedSquares(int[] a) {
        int n = a.length;
        int[] ans = new int[n];
        int l = 0, r = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (Math.abs(a[l]) >= Math.abs(a[r])) {
                ans[i] = a[l] * a[l];
                l++;
            } else {
                ans[i] = a[r] * a[r];
                r--;
            }
        }
        return ans;
    }
}
