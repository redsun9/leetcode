package leetcode.leetcode37xx.leetcode3759;

import java.util.Arrays;

public class Solution {
    public int countElements(int[] nums, int k) {
        if (k == 0) return nums.length;
        Arrays.sort(nums);
        int threshold = nums[nums.length - k];
        int ans = nums.length - k - 1;
        while (ans >= 0 && nums[ans] == threshold) ans--;
        return ans + 1;
    }
}
