package leetcode.leetcode3xx.leetcode322;

import java.util.Arrays;

public class Solution2 {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int m = coins.length;
        return dfs(coins, amount, m - 1, 0, Integer.MAX_VALUE);
    }

    private static int dfs(int[] coins, int amount, int i, int curr, int currMin) {
        if (amount == 0) return 0;
        int coin = coins[i];
        if (amount % coin == 0) return amount / coin;
        if (i == 0) return -1;

        int nextCoin = coins[i - 1];
        int min = Integer.MAX_VALUE;
        for (int j = amount / coin, left = amount % coin; j >= 0; j--, left += coin) {
            if (curr + j + (left + nextCoin - 1) / nextCoin >= currMin) break; //pruning
            int tmp = dfs(coins, left, i - 1, curr + j, currMin);
            if (tmp != -1) {
                min = Math.min(min, tmp + j);
                currMin = Math.min(currMin, curr + tmp + j);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
