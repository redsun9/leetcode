package leetcode.leetcode493;

import java.util.Arrays;

public class Solution {
    public int reversePairs(int[] nums) {
        if (nums.length < 2) return 0;
        long[] a = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[i] = nums[i];
        }
        return mergeSort(a, 0, a.length);
    }

    private static int mergeSort(long[] nums, int left, int right) {
        if (right - left < 2) return 0;
        int mid = left + (right - left) / 2;
        int ans = mergeSort(nums, left, mid) + mergeSort(nums, mid, right);
        Arrays.sort(nums, left, mid);
        Arrays.sort(nums, mid, right);
        for (int i = left, j = mid; i < mid; i++) {
            while (j < right && nums[i] > nums[j] * 2) j++;
            ans += j - mid;
        }
        return ans;
    }
}
