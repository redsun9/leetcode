package leetcode.leetcode6xx.leetcode643;

public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int ans = sum;
        for (int i = k, j = 0; i < nums.length; i++, j++) {
            sum = sum + nums[i] - nums[j];
            ans = Math.max(ans, sum);
        }
        return ans / (double) k;
    }
}
