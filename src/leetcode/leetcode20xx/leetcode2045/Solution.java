package leetcode.leetcode20xx.leetcode2045;

import java.util.*;

@SuppressWarnings("unchecked")
public class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] edge : edges) {
            int u = edge[0] - 1, v = edge[1] - 1;
            adj[u].add(v);
            adj[v].add(u);
        }

        int[][] dp = new int[2][n];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        Arrays.fill(dp[1], Integer.MAX_VALUE);
        dp[0][0] = 0;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            int nextVal = dp[0][u] + 1;
            for (Integer v : adj[u]) {
                if (dp[1][v] <= nextVal || dp[0][v] == nextVal) continue;
                if (dp[0][v] > nextVal) {
                    dp[1][v] = dp[0][v];
                    dp[0][v] = nextVal;
                } else {
                    dp[1][v] = nextVal;
                }
                queue.offer(v);
            }
            if (dp[1][u] == Integer.MAX_VALUE) continue;
            nextVal = dp[1][u] + 1;
            for (Integer v : adj[u]) {
                if (dp[1][v] <= nextVal || dp[0][v] == nextVal) continue;
                dp[1][v] = nextVal;
                queue.offer(v);
            }
        }
        return calculate(dp[1][n - 1], time, change);
    }

    private static int calculate(int dist, int time, int change) {
        int cycle = 2 * change;
        int ans = 0;
        for (int i = 0; i < dist; i++) {
            if (ans % cycle >= change) ans += cycle - ans % cycle;
            ans += time;
        }
        return ans;
    }
}
