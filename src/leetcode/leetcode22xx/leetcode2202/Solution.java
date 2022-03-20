package leetcode.leetcode22xx.leetcode2202;

public class Solution {
    public int maximumTop(int[] nums, int k) {
        int n = nums.length;
        if (n == 1 && ((k & 1) == 1)) return -1;
        if (n == 1) return nums[0];
        if (k <= 1) return nums[k];

        int ans = -1;
        for (int i = Math.min(n - 1, k - 2); i >= 0; i--) ans = Math.max(ans, nums[i]);
        if (n > k) ans = Math.max(ans, nums[k]);
        return ans;
    }
}
