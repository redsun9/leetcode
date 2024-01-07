package leetcode.leetcode25xx.leetcode2574;

public class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int diff = 0, tmp;
        for (int num : nums) diff += num;
        for (int i = 0; i < n; i++) {
            tmp = nums[i];
            nums[i] = Math.abs(diff - nums[i]);
            diff -= 2 * tmp;
        }
        return nums;
    }
}
