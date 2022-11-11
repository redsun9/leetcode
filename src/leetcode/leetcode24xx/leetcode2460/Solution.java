package leetcode.leetcode24xx.leetcode2460;

import java.util.Arrays;

public class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length, pos = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] == nums[i]) {
                nums[i - 1] <<= 1;
                nums[i] = 0;
            }
        }
        for (int i = 0; i < n; i++) if (nums[i] != 0) nums[pos++] = nums[i];
        Arrays.fill(nums, pos, n, 0);
        return nums;
    }
}
