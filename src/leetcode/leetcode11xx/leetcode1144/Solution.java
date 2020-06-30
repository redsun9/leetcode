package leetcode.leetcode11xx.leetcode1144;

public class Solution {
    private static int helper(boolean asc, int[] nums) {
        int pre = nums[0];
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            int diff = Math.abs(pre - nums[i]);
            if (asc) {
                count += nums[i] <= pre ? diff + 1 : 0;
                pre = nums[i];
            } else {
                count += nums[i] >= pre ? diff + 1 : 0;
                pre = nums[i] >= pre ? pre - 1 : nums[i];
            }
            asc = !asc;
        }
        return count;
    }

    public int movesToMakeZigzag(int[] nums) {
        int v1 = helper(true, nums);
        int v2 = helper(false, nums);
        return Math.min(v1, v2);
    }
}
