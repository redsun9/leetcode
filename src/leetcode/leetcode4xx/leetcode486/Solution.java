package leetcode.leetcode4xx.leetcode486;

public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        if (n <= 2) return true;
        if (n == 3) return nums[0] + nums[2] >= nums[1];

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = nums[i];
        for (int d = 1; d < n; d++) {
            for (int l = 0, r = d; r < n; l++, r++) {
                dp[l][r] = Math.max(nums[l] - dp[l + 1][r], nums[r] - dp[l][r - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }
}
