package leetcode.leetcode7xx.leetcode746;

public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n == 1) return cost[0];
        for (int i = 2; i < n; i++) {
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }
        return Math.min(cost[n - 1], cost[n - 2]);
    }
}
