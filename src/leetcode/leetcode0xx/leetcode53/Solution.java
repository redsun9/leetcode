package leetcode.leetcode0xx.leetcode53;

public class Solution {
    public int maxSubArray(int[] nums) {
        int maxNumber = Integer.MIN_VALUE, maxSum = 0, curSum = 0;
        for (int num : nums) {
            curSum += num;
            if (curSum > 0) maxSum = Math.max(maxSum, curSum);
            else curSum = 0;
            maxNumber = Math.max(maxNumber, num);
        }
        return maxNumber >= 0 ? maxSum : maxNumber;
    }
}
