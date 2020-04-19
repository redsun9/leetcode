package leetcode.leetcode0xx.leetcode33;

public class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;
        if (nums[0] == target) return 0;
        if (nums[n - 1] == target) return n - 1;
        int lo = 0;
        int hi = n - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return mid;
            if (nums[lo] < nums[hi]) {
                if (nums[mid] < target) lo = mid + 1;
                else hi = mid - 1;
            } else {
                if (nums[mid] > nums[lo]) {
                    if (nums[mid] <= target) lo = mid;
                    else if (target >= nums[lo]) hi = mid;
                    else lo = mid + 1;
                } else {
                    if (nums[mid] >= target) hi = mid;
                    else if (target <= nums[hi]) lo = mid;
                    else hi = mid - 1;
                }
            }
        }
        if (lo < n && nums[lo] == target) return lo;
        if (hi > 0 && nums[hi] == target) return hi;
        return -1;
    }
}
