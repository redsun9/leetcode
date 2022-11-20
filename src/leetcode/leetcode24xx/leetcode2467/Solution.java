package leetcode.leetcode24xx.leetcode2467;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "DataFlowIssue"})
public class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = edges.length + 1;
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        int[] parent = new int[n];
        parent[0] = -1;
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, -1});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int u = poll[0], p = poll[1];
            parent[u] = p;
            for (Integer v : adj[u]) {
                if (v == p) continue;
                queue.offer(new int[]{v, u});
            }
        }

        int ans = Integer.MIN_VALUE;
        queue.add(new int[]{0, amount[0]});

        while (!queue.isEmpty()) {
            int size = queue.size();
            if (bob != -1) {
                amount[bob] = 0;
                bob = parent[bob];
            }
            for (int i = 0; i < size; i++) {
                int[] poll = queue.pollFirst();
                int u = poll[0], val = poll[1], p = parent[u];
                for (Integer v : adj[u]) {
                    if (v == p) continue;
                    if (v != bob) queue.offerLast(new int[]{v, val + amount[v]});
                    else queue.offerLast(new int[]{v, val + amount[v] / 2});
                }
                if (adj[u].size() == 1 && u != 0) ans = Math.max(ans, val);
            }
        }
        return ans;
    }
}
