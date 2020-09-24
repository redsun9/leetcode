package leetcode.leetcode3xx.leetcode322;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = -1;
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != -1)
                    min = min == -1 ? dp[i - coin] + 1 : Math.min(min, dp[i - coin] + 1);
            }
            dp[i] = min;
        }
        return dp[amount];
    }
}
