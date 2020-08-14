package leetcode.leetcode7xx.leetcode747;

public class Solution {
    public int dominantIndex(int[] nums) {
        int prevMax = 0;
        int curMax = nums[0];
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > curMax) {
                prevMax = curMax;
                curMax = nums[i];
                ans = i;
            } else if (nums[i] > prevMax) {
                prevMax = nums[i];
            }
        }
        return curMax >= prevMax * 2 ? ans : -1;
    }
}
