package leetcode.leetcode3xx.leetcode322;

import java.util.Arrays;

public class Solution4 {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int m = coins.length;
        int[][] dp = new int[m][amount + 1];
        return dfs(coins, amount, m - 1, dp);
    }

    private static int dfs(int[] coins, int amount, int i, int[][] dp) {
        if (amount == 0) return 0;
        if (dp[i][amount] != 0) return dp[i][amount];
        int coin = coins[i];
        if (amount % coin == 0) return amount / coin;
        if (i == 0) return -1;

        int min = Integer.MAX_VALUE;
        for (int j = amount / coin, left = amount % coin; j >= 0; j--, left += coin) {
            int tmp = dfs(coins, left, i - 1, dp);
            if (tmp != -1) min = Math.min(min, tmp + j);
        }
        dp[i][amount] = min == Integer.MAX_VALUE ? -1 : min;
        return dp[i][amount];
    }
}
