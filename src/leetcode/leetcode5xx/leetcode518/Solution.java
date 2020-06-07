package leetcode.leetcode5xx.leetcode518;

public class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin, j = 0; i <= amount; i++, j++) {
                dp[i] += dp[j];
            }
        }
        return dp[amount];
    }
}
