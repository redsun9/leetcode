package leetcode.leetcode11xx.leetcode1129;

import java.util.*;

@SuppressWarnings("unchecked")
public class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] dp = new int[n << 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 0;

        List<Integer>[] adj = new List[n << 1];
        for (int i = (n << 1) - 1; i >= 0; i--) adj[i] = new ArrayList<>();
        for (int[] edge : blueEdges) adj[edge[0] << 1].add(edge[1] << 1 | 1);
        for (int[] edge : redEdges) adj[edge[0] << 1 | 1].add(edge[1] << 1);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        queue.add(1);
        while (!queue.isEmpty()) {
            int u = queue.poll(), val = dp[u] + 1;
            for (Integer v : adj[u]) {
                if (dp[v] != Integer.MAX_VALUE) continue;
                dp[v] = val;
                queue.add(v);
            }
        }

        int[] ans = new int[n];
        for (int i = 0, i1 = 0, i2 = 1; i < n; i++, i1 += 2, i2 += 2) {
            int tmp = Math.min(dp[i1], dp[i2]);
            ans[i] = tmp == Integer.MAX_VALUE ? -1 : tmp;
        }
        return ans;
    }
}
