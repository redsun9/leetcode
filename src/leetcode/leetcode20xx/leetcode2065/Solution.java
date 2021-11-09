package leetcode.leetcode20xx.leetcode2065;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"DuplicatedCode", "unchecked"})
public class Solution {
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        int n = values.length;
        List<int[]>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] edge : edges) {
            adj[edge[0]].add(new int[]{edge[1], edge[2]});
            adj[edge[1]].add(new int[]{edge[0], edge[2]});
        }

        int[] tmp = new int[n];
        return dfs(0, maxTime, values, adj, tmp);
    }


    private static int dfs(int u, int leftTime, int[] values, List<int[]>[] adj, int[] tmp) {
        int addition = tmp[u]++ == 0 ? values[u] : 0;
        int max = u == 0 ? 0 : Integer.MIN_VALUE;

        for (int[] edge : adj[u]) {
            if (leftTime >= edge[1]) max = Math.max(max, dfs(edge[0], leftTime - edge[1], values, adj, tmp));
        }
        tmp[u]--;
        return max != Integer.MIN_VALUE ? addition + max : Integer.MIN_VALUE;
    }
}
