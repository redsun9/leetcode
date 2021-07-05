package leetcode.leetcode9xx.leetcode908;

public class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int min = nums[0], max = nums[0];
        for (int num : nums) {
            if (num > max) max = num;
            else if (num < min) min = num;
        }
        return Math.max(0, max - min - 2 * k);
    }
}
