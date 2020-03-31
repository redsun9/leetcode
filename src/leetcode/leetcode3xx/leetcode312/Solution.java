package leetcode.leetcode3xx.leetcode312;

public class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int[] balloons = new int[n + 2];
        for (int i = 0; i < n; i++) {
            balloons[i + 1] = nums[i];
        }
        balloons[0] = 1;
        balloons[n + 1] = 1;
        int[][] dp = new int[n + 2][n + 2];
        return maxCoins(balloons, 0, n + 1, dp);
    }

    public int maxCoins(int[] balloons, int from, int to, int[][] dp) {
        if (from == to - 1) {
            return 0;
        }
        if (dp[from][to] != 0) return dp[from][to];
        int ans = 0;
        int edges = balloons[from] * balloons[to];
        if (from == to - 2) {
            ans = edges * balloons[from + 1];
        } else {
            for (int i = from + 1; i < to; i++) {

                ans = Math.max(ans, edges * balloons[i] + maxCoins(balloons, from, i, dp) + maxCoins(balloons, i, to, dp));
            }
        }
        dp[from][to] = ans;
        return ans;
    }
}
