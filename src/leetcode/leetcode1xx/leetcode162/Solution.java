package leetcode.leetcode1xx.leetcode162;

public class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        if (n == 2) return nums[0] > nums[1] ? 0 : 1;
        int lo = 0, hi = n - 1;
        while (hi - lo > 2) {
            int mid = lo + (hi - lo) / 2;
            int a = nums[mid - 1];
            int b = nums[mid];
            int c = nums[mid + 1];
            if (b > a && b > c) return mid;
            else if (a > b) hi = mid;
            else lo = mid;
        }
        if (nums[lo] > nums[lo + 1]) return lo;
        if (nums[hi] > nums[hi - 1]) return hi;
        else return lo + 1;
    }
}
