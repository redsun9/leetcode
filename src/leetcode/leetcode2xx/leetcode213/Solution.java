package leetcode.leetcode2xx.leetcode213;

public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        return Math.max(rob(nums, 1, n), rob(nums, 0, n - 1));
    }


    private static int rob(int[] nums, int start, int end) {
        int p = 0; // -2
        int q = 0; // -1
        int r = 0;
        int tmp;
        for (int i = start; i < end; i++) {
            tmp = nums[i] + Math.max(p, q);
            p = q;
            q = r;
            r = tmp;
        }
        return Math.max(q, r);
    }
}
