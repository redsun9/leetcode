package leetcode.leetcode0xx.leetcode35;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) hi = mid;
            if (nums[mid] < target) lo = mid + 1;
        }
        return lo;
    }
}
