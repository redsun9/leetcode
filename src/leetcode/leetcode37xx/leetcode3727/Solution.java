package leetcode.leetcode37xx.leetcode3727;

import java.util.Arrays;

public class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) nums[i] = nums[i] * nums[i];
        Arrays.sort(nums);
        long ans = 0;
        for (int i = 0; i < n / 2; i++) ans -= nums[i];
        for (int i = n / 2; i < n; i++) ans += nums[i];
        return ans;
    }
}
