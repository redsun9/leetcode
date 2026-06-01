package leetcode.leetcode37xx.leetcode3743;

import java.util.Arrays;

// O(n * k)
public class Solution2 {
    public long maximumScore(int[] nums, int k) {
        int n = nums.length;
        k = Math.min(k, n / 2);
        int maxIndex = maxIndex(nums);
        return Math.max(helper(nums, k, maxIndex), helper(nums, k, (maxIndex + 1) % n));
    }

    private static int maxIndex(int[] nums) {
        int max = nums[0], maxIdx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    private static long helper(int[] nums, int k, int start) {
        int n = nums.length;
        long[][] dp = new long[k + 2][3];
        for (long[] row : dp) Arrays.fill(row, Integer.MIN_VALUE);
        for (int i = 1; i < dp.length; i++) dp[i][0] = 0;

        int i = start;
        do {
            for (int j = k + 1; j > 0; j--) {
                dp[j][0] = Math.max(dp[j][0], Math.max(dp[j][1] + nums[i], dp[j][2] - nums[i]));
                dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] - nums[i]);
                dp[j][2] = Math.max(dp[j][2], dp[j - 1][0] + nums[i]);
            }
            i = (i + 1) % n;
        } while (i != start);
        return dp[k + 1][0];
    }
}
