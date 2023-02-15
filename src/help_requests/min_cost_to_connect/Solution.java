package help_requests.min_cost_to_connect;

import java.util.*;

public class Solution {
    public static int minCostToConnect(int[] nodes, int[][] edges) {
        int n = nodes.length;
        List<int[]>[] adj = new List[n];
        for (int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            if (adj[u] == null) adj[u] = new ArrayList<>();
            if (adj[v] == null) adj[v] = new ArrayList<>();
            adj[u].add(new int[]{v, edge[2]});
            adj[v].add(new int[]{u, edge[2]});
        }
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (int i = 0; i < n; i++) {
            if (nodes[i] != 1) continue;
            pq.add(new int[]{i, 0});
            cost[i] = 0;
        }

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            int curCost = cur[1];
            if (curCost > cost[u]) continue;
            if (adj[u] == null) continue;
            for (int[] next : adj[u]) {
                int v = next[0];
                int nextCost = curCost + next[1];
                if (nextCost < cost[v]) {
                    cost[v] = nextCost;
                    if (nodes[v] == 2) return nextCost;
                    pq.add(new int[]{v, nextCost});
                }
            }
        }
        return -1;
    }
}
