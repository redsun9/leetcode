package leetcode.leetcode23xx.leetcode2334;

public class Solution {
    public int validSubarraySize(int[] nums, int threshold) {
        int n = nums.length;
        int[] left = new int[n]; //index of the first left element which is smaller
        for (int i = 0; i < n; i++) {
            int pos = i - 1;
            while (pos != -1 && nums[i] <= nums[pos]) pos = left[pos];
            left[i] = pos;
        }

        int[] right = new int[n]; //index of the first right element which is smaller
        for (int i = n - 1; i >= 0; i--) {
            int pos = i + 1;
            while (pos != n && nums[i] <= nums[pos]) pos = right[pos];
            right[i] = pos;
        }

        for (int i = 0; i < n; i++) {
            int length = right[i] - left[i] - 1;
            if (nums[i] > threshold / (length)) return length;
        }
        return -1;
    }
}
