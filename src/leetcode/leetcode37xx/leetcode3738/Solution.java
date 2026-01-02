package leetcode.leetcode37xx.leetcode3738;

public class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;
        int[] left = new int[n], right = new int[n];
        for (int i = 1; i < n; i++) if (nums[i] >= nums[i - 1]) left[i] = left[i - 1] + 1;
        for (int i = n - 2; i >= 0; i--) if (nums[i] <= nums[i + 1]) right[i] = right[i + 1] + 1;

        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            if (nums[i - 1] <= nums[i + 1]) ans = Math.max(ans, right[i + 1] + left[i - 1] + 3);
        }
        for (int i = 0; i < n - 1; i++) ans = Math.max(ans, right[i + 1] + 2);
        for (int i = 1; i < n; i++) ans = Math.max(ans, left[i - 1] + 2);
        return ans;
    }
}
