package leetcode.leetcode17xx.leetcode1786;

import java.util.*;

public class Solution {
    public static final int p = 1_000_000_007;

    public int countRestrictedPaths(int n, int[][] edges) {
        int[] dp = new int[n];
        dp[n - 1] = 1;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n - 1] = 0;
        List<int[]>[] neighbors = new LinkedList[n];
        for (int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            int w = edge[2];
            if (neighbors[u] == null) neighbors[u] = new LinkedList<>();
            neighbors[u].add(new int[]{v, w});
            if (neighbors[v] == null) neighbors[v] = new LinkedList<>();
            neighbors[v].add(new int[]{u, w});
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(i -> dist[i]));
        pq.add(n - 1);
        while (!pq.isEmpty()) {
            Integer node = pq.poll();
            int curDist = dist[node];
            int curDp = dp[node];
            for (int[] neighbor : neighbors[node]) {
                if (dist[neighbor[0]] < curDist) curDp = (curDp + dp[neighbor[0]]) % p;
                else if (dist[neighbor[0]] > curDist + neighbor[1]) {
                    pq.remove(neighbor[0]);
                    dist[neighbor[0]] = curDist + neighbor[1];
                    pq.add(neighbor[0]);
                }
            }
            dp[node] = curDp;
        }
        return dp[0];
    }
}
