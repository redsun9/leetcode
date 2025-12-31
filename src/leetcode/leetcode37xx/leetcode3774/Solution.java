package leetcode.leetcode37xx.leetcode3774;

import java.util.Arrays;

public class Solution {
    public int absDifference(int[] nums, int k) {
        Arrays.sort(nums);
        k = Math.min(k, nums.length - k);
        int tmp = 0;
        for (int i = 0, j = nums.length - 1; i < k; i++, j--) tmp += nums[j] - nums[i];
        return tmp;
    }
}
