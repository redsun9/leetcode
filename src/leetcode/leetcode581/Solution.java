package leetcode.leetcode581;

import java.util.Arrays;

public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;
        if (n == 2) return nums[0] > nums[1] ? 2 : 0;
        Integer[] a = new Integer[n];
        for (int i = 0; i < nums.length; i++) {
            a[i] = nums[i];
        }
        int leftPos = n;
        int leftValue = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1] && nums[i] < leftValue) {
                leftPos = Arrays.binarySearch(
                        a, 0, Math.min(i, leftPos), nums[i],
                        (x, key) -> key >= x ? -1 : 1
                );
                leftPos = -leftPos - 1;
                if (leftPos == 0) break;
                leftValue = nums[i];
            }
        }

        int rightPos = 0;
        int rightValue = Integer.MIN_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1] && nums[i] > rightValue) {
                rightPos = Arrays.binarySearch(
                        a, Math.max(i + 1, rightPos), n, nums[i],
                        (x, key) -> key <= x ? 1 : -1
                );
                rightPos = -rightPos - 1;
                if (rightPos == n) break;
                rightValue = nums[i];
            }
        }
        return Math.max(rightPos - leftPos, 0);
    }
}
