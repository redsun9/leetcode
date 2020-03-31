package leetcode.leetcode0xx.leetcode55;

public class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (i > max) return false;
            if (nums[i] != 0) {
                max = Math.max(max, i + nums[i]);
                if (max >= n - 1) return true;
            }
        }
        return true;
    }
}
