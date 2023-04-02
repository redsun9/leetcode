package leetcode.leetcode25xx.leetcode2562;

public class Solution {
    public long findTheArrayConcVal(int[] nums) {
        long ans = 0;
        for (int l = 0, r = nums.length - 1; l <= r; l++, r--) {
            if (l == r) ans += nums[l];
            else ans += addZeros(nums[l], nums[r]);
        }
        return ans;
    }

    private static long addZeros(int a, int b) {
        if (b >= 10_000) return a * 100000L + b;
        if (b >= 1000) return a * 10000L + b;
        if (b >= 100) return a * 1000L + b;
        if (b >= 10) return a * 100L + b;
        return a * 10L + b;
    }
}
