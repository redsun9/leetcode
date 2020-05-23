package leetcode.leetcode12xx.leetcode1283;

public class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int lo = 1, hi = 1_000_001;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int tmp = 0;
            for (int num : nums) {
                tmp += (num + mid - 1) / mid;
            }
            if (tmp > threshold) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
