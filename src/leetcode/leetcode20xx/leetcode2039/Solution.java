package leetcode.leetcode20xx.leetcode2039;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@SuppressWarnings({"ConstantConditions", "unchecked"})
public class Solution {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        int[] dp = new int[n];
        int time = 1;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int genSize = queue.size();
            while (genSize-- != 0) {
                int u = queue.poll();
                for (Integer v : adj[u]) {
                    if (v == 0 || dp[v] != 0) continue;
                    dp[v] = time;
                    queue.offer(v);
                }
            }
            time++;
        }
        int ans = 0;
        for (int i = 1; i < n; i++) ans = Math.max(ans, (2 * dp[i] - 1) / patience[i] * patience[i] + 2 * dp[i]);
        return ans + 1;
    }
}
