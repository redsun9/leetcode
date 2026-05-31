package leetcode.leetcode39xx.leetcode3928;

import java.util.*;

// Dijkstra
public class Solution2 {
    public int[] minCost(int n, int[] prices, int[][] roads) {
        List<long[]>[] adj1 = new List[n], adj2 = new List[n];
        for (int i = 0; i < n; i++) adj1[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) adj2[i] = new ArrayList<>();

        for (int[] road : roads) {
            int u = road[0], v = road[1], cost = road[2];
            long tax = (long) road[2] * road[3];
            adj1[u].add(new long[]{v, cost});
            adj1[v].add(new long[]{u, cost});
            adj2[u].add(new long[]{v, tax});
            adj2[v].add(new long[]{u, tax});
        }

        long[][] costs = new long[n][], taxes = new long[n][];
        for (int i = 0; i < n; i++) {
            costs[i] = dijkstra(i, prices[i], adj1);
            taxes[i] = dijkstra(i, prices[i], adj2);
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (costs[i][j] != Long.MAX_VALUE && taxes[i][j] != Long.MAX_VALUE) ans[i] = (int) Math.min(ans[i], costs[i][j] + prices[j] + taxes[i][j]);
            }
        }
        return ans;
    }

    private static long[] dijkstra(int from, int cap, List<long[]>[] adj) {
        int n = adj.length;
        long[] dp = new long[n];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[from] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(x -> x[1]));
        pq.add(new long[]{from, 0});

        while (!pq.isEmpty()) {
            long[] poll = pq.poll();
            int u = (int) poll[0];
            long d = poll[1];
            if (dp[u] < d) continue;
            for (long[] road : adj[u]) {
                int v = (int) road[0];
                long tmp = d + road[1];
                if (dp[v] > tmp && tmp < cap) {
                    dp[v] = tmp;
                    pq.offer(new long[]{v, tmp});
                }
            }
        }
        return dp;
    }
}
