package leetcode.leetcode39xx.leetcode3928;

import java.util.Arrays;

// Floyd's algorithm
public class Solution {
    public int[] minCost(int n, int[] prices, int[][] roads) {
        long[][] costs = new long[n][n], taxes = new long[n][n];
        for (long[] row : costs) Arrays.fill(row, Long.MAX_VALUE);
        for (long[] row : taxes) Arrays.fill(row, Long.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            costs[i][i] = 0;
            taxes[i][i] = 0;
        }
        for (int[] road : roads) {
            int u = road[0], v = road[1], cost = road[2], tax = road[2] * road[3];
            costs[u][v] = Math.min(costs[u][v], cost);
            costs[v][u] = Math.min(costs[v][u], cost);
            taxes[u][v] = Math.min(taxes[u][v], tax);
            taxes[v][u] = Math.min(taxes[v][u], tax);
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (costs[i][k] != Long.MAX_VALUE && costs[k][j] != Long.MAX_VALUE) costs[i][j] = Math.min(costs[i][j], costs[i][k] + costs[k][j]);
                    if (taxes[i][k] != Long.MAX_VALUE && taxes[k][j] != Long.MAX_VALUE) taxes[i][j] = Math.min(taxes[i][j], taxes[i][k] + taxes[k][j]);
                }
            }
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (costs[i][j] != Long.MAX_VALUE && taxes[j][i] != Long.MAX_VALUE) ans[i] = (int) Math.min(ans[i], costs[i][j] + prices[j] + taxes[j][i]);
            }
        }
        return ans;
    }
}
