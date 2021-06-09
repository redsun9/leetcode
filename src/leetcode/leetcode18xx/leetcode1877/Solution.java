package leetcode.leetcode18xx.leetcode1877;

import java.util.Arrays;

public class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[nums.length - 1];
        for (int i = 1, j = nums.length - 2; i < j; i++, j--) {
            ans = Math.max(ans, nums[i] + nums[j]);
        }
        return ans;
    }
}
