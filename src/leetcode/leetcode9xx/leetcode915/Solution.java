package leetcode.leetcode9xx.leetcode915;

public class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int left = 0;
        int leftMax = nums[0];
        int rightMax = nums[1];
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] < leftMax) {
                left = i;
                leftMax = Math.max(leftMax, rightMax);
                rightMax = nums[i + 1];
            } else {
                rightMax = Math.max(rightMax, nums[i]);
            }
        }
        return left + 1;
    }
}
