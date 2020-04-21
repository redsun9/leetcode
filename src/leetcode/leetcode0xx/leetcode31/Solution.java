package leetcode.leetcode0xx.leetcode31;

public class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int k = n - 2;
        for (; k >= 0; k--) if (nums[k] < nums[k + 1]) break;

        if (k < 0) {
            reverse(nums, 0, n - 1);
        } else {
            int l = n - 1;
            for (; l > k + 1; l--) if (nums[k] < nums[l]) break;
            swap(nums, k, l);
            reverse(nums, k + 1, n - 1);
        }
    }

    private static void reverse(int[] nums, int from, int to) {
        while (from < to) swap(nums, from++, to--);
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
