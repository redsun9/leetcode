package leetcode.leetcode14xx.leetcode1498;

import java.util.Arrays;

public class Solution {
    public static final int mod = 1_000_000_007;

    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return 0;
        Arrays.sort(nums);
        long[] p = new long[n + 1];
        p[0] = 1;
        for (int i = 0; i < n; i++) p[i + 1] = p[i] * 2 % mod;

        if (nums[0] * 2 > target) return 0;
        long ans = 0;
        int lo = 0;
        int hi = n - 1;
        while (lo <= hi) {
            if (nums[lo] + nums[hi] <= target) {
                ans = (ans + p[hi - lo]) % mod;
                lo++;
            } else hi--;
        }
        return (int) ans;
    }
}
