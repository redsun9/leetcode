package leetcode.leetcode37xx.leetcode3752;

public class Solution {
    public int[] lexSmallestNegatedPerm(int n, long target) {
        long total = n * (n + 1L) / 2;
        if (total < Math.abs(target) || ((total ^ target) & 1) != 0) return new int[0];
        int[] ans = new int[n];
        for (int i = n, l = 0, r = n - 1; i > 0; i--) {
            if (Math.abs(target + i) <= i * (i - 1L) / 2) {
                ans[l++] = -i;
                target += i;
            } else {
                ans[r--] = i;
                target -= i;
            }
        }
        return ans;
    }
}
