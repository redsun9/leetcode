package leetcode.leetcode25xx.leetcode2560;

public class Solution {
    public int minCapability(int[] nums, int k) {
        int n = nums.length, max = 0;
        for (int num : nums) max = Math.max(max, num);
        int lo = 1, hi = max;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (check(nums, k, mid)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    private static boolean check(int[] nums, int k, int val) {
        boolean prevRobbed = false;
        for (int num : nums) {
            if (prevRobbed) prevRobbed = false;
            else if (num <= val) {
                prevRobbed = true;
                if (--k == 0) return true;
            }
        }
        return false;
    }
}
