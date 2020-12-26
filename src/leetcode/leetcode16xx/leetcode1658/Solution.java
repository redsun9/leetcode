package leetcode.leetcode16xx.leetcode1658;

public class Solution {
    public int minOperations(int[] nums, int x) {
        int s = 0, l = 0, ans = -1, n = nums.length;
        while (s < x && l < n) s += nums[l++];
        if (s == x) ans = l;
        if (s < x) return -1;
        if (l == n) return ans;
        int r = n;
        while (l > 0) {
            s -= nums[--l];
            while (s < x) s += nums[--r];
            if (s == x) {
                ans = ans == -1 ? l + (n - r) : Math.min(ans, l + n - r);
            }
        }
        return ans;
    }
}
