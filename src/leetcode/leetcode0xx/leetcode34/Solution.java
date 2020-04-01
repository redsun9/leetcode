package leetcode.leetcode0xx.leetcode34;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        if (nums.length == 0) return ans;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo != hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        if (nums[lo] == target) ans[0] = lo;

        lo = 0;
        hi = nums.length - 1;
        while (lo != hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (nums[mid] > target) hi = mid - 1;
            else lo = mid;
        }
        if (nums[lo] == target) ans[1] = lo;
        return ans;
    }
}
