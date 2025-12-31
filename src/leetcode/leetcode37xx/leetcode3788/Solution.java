package leetcode.leetcode37xx.leetcode3788;

public class Solution {
    public long maximumScore(int[] nums) {
        long prefSum = 0;
        for (int num : nums) prefSum += num;
        long ans = Long.MIN_VALUE;
        for (int i = nums.length - 1, min = Integer.MAX_VALUE; i > 0; i--) {
            min = Math.min(min, nums[i]);
            prefSum -= nums[i];
            ans = Math.max(ans, prefSum - min);
        }
        return ans;
    }
}
