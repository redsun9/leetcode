package leetcode.leetcode9xx.leetcode910;

import java.util.Arrays;

public class Solution {
    public int smallestRangeII(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) return 0;
        if (n == 2) {
            int d = Math.abs(nums[0] - nums[1]);
            return Math.min(d, Math.abs(d - 2 * k));
        }
        Arrays.sort(nums);
        k *= 2;
        int ans = nums[n - 1] - nums[0];
        if (ans == 0) return ans;
        int max = nums[n - 1], min;
        int first = nums[0] + k;
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, nums[i] + k);
            min = Math.min(first, nums[i + 1]);
            ans = Math.min(ans, max - min);
        }
        return ans;
    }
}
