package leetcode.leetcode25xx.leetcode2567;

import java.util.Arrays;

public class Solution {
    public int minimizeSum(int[] nums) {
        int n = nums.length;
        if (n <= 3) return 0;
        Arrays.sort(nums);
        return Math.min(Math.min(nums[n - 1] - nums[2], nums[n - 3] - nums[0]), nums[n - 2] - nums[1]);
    }
}
