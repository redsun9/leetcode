package leetcode.leetcode17xx.leetcode1760;

public class Solution {
    private static boolean check(int[] nums, int value, int maxOperations) {
        for (int num : nums) {
            int tmp = (num + value - 1) / value;
            if (tmp > 1) {
                maxOperations -= tmp - 1;
                if (maxOperations < 0) return false;
            }
        }
        return true;
    }

    public int minimumSize(int[] nums, int maxOperations) {
        int lo = 1;
        int hi = 1;
        for (int num : nums) {
            hi = Math.max(hi, num);
        }
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (check(nums, mid, maxOperations)) hi = mid;
            else lo = mid + 1;
        }
        return hi;
    }
}
