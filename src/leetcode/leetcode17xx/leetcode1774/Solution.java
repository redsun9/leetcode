package leetcode.leetcode17xx.leetcode1774;

public class Solution {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int maxConsider = 2 * target - 1;
        boolean[] dp = new boolean[maxConsider + 1];
        int minBase = Integer.MAX_VALUE;
        for (int baseCost : baseCosts) {
            if (baseCost <= maxConsider) dp[baseCost] = true;
            minBase = Math.min(minBase, baseCost);
        }
        for (int toppingCost : toppingCosts) {
            for (int i = Math.min(maxConsider, target - 1 + toppingCost),
                 j = i - toppingCost, k = j - toppingCost; j >= 0; i--, j--, k--) {
                dp[i] |= dp[j] || (k >= 0 && dp[k]);
            }
        }
        int ans = minBase;
        int diff = Math.abs(ans - target);
        for (int i = 1; i <= maxConsider; i++) {
            if (dp[i] && Math.abs(i - target) < diff) {
                ans = i;
                diff = Math.abs(i - target);
            }
        }
        return ans;
    }
}
