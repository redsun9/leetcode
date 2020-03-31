package leetcode.leetcode2xx.leetcode283;

import java.util.Arrays;

public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length < 2) return;
        int placeToPut = 0;
        for (int num : nums) {
            if (num != 0) nums[placeToPut++] = num;
        }
        Arrays.fill(nums, placeToPut, nums.length, 0);
    }
}
