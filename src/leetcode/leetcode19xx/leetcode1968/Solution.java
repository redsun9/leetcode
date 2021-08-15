package leetcode.leetcode19xx.leetcode1968;

import java.util.Arrays;

public class Solution {
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0, j = 0; i < n; i += 2, j++) ans[i] = nums[j];
        for (int i = 1, j = n - 1; i < n; i += 2, j--) ans[i] = nums[j];
        return ans;
    }
}
