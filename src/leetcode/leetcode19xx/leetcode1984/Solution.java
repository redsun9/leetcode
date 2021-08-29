package leetcode.leetcode19xx.leetcode1984;

import java.util.Arrays;

public class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0, j = k - 1; j < n; i++, j++) ans = Math.min(ans, nums[j] - nums[i]);
        return ans;
    }
}
