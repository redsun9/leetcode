package leetcode.leetcode1xx.leetcode153;

public class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int lo = 0, hi = n - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else if (nums[mid] < nums[hi]) {
                hi = mid;
            } else hi--;
        }
        return nums[lo];
    }
}
