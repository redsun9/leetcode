package leetcode.leetcode19xx.leetcode1928;

import java.util.*;

@SuppressWarnings("unchecked")
public class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        List<int[]>[] adj = new List[n];
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], t = edge[2];
            if (adj[u] == null) adj[u] = new ArrayList<>();
            if (adj[v] == null) adj[v] = new ArrayList<>();
            adj[u].add(new int[]{v, t, passingFees[v]});
            adj[v].add(new int[]{u, t, passingFees[u]});
        }
        if (adj[0] == null || adj[n - 1] == null) return -1;
        int[] cost = new int[n], time = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        Arrays.fill(time, Integer.MAX_VALUE);
        cost[0] = passingFees[0];
        time[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingInt((int[] x) -> x[0])
                        .thenComparingInt(x -> x[1])
        );

        pq.offer(new int[]{cost[0], time[0], 0});
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int c = poll[0], t = poll[1], v = poll[2];
            for (int[] road : adj[v]) {
                int newV = road[0];
                int newT = t + road[1];
                int newC = c + road[2];
                if (newT <= maxTime) {
                    if (cost[newV] > newC) {
                        cost[newV] = newC;
                        time[newV] = newT;
                        pq.offer(new int[]{newC, newT, newV});
                    } else if (time[newV] > newT) {
                        time[newV] = newT;
                        pq.offer(new int[]{newC, newT, newV});
                    }
                }
            }
        }
        return cost[n - 1] == Integer.MAX_VALUE ? -1 : cost[n - 1];
    }
}
