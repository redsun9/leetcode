package leetcode.leetcode16xx.leetcode1617;

import java.util.*;

@SuppressWarnings({"ManualMinMaxCalculation", "unchecked"})
public class Solution {
    private static void dfs(
            int node, int adjPos, int adjSize,
            int curD, int curH, int curVal, UsefulData data
    ) {
        while (adjPos < adjSize && data.processed[data.adj[node].get(adjPos)]) adjPos++;
        if (adjPos == adjSize) {
            data.dp[node].compute(new HD(curH, curD), (k, v) -> v == null ? curVal : v + curVal);
        } else {
            HashMap<HD, Integer> map = data.dp[data.adj[node].get(adjPos++)];
            for (Map.Entry<HD, Integer> entry : map.entrySet()) {
                dfs(
                        node, adjPos, adjSize,
                        max(curD, entry.getKey().diameter, curH + entry.getKey().height + 1),
                        max(curH, entry.getKey().height + 1),
                        curVal * entry.getValue(), data
                );
            }
            dfs(node, adjPos, adjSize, curD, curH, curVal, data);
        }
    }

    private static int max(int a, int b) {
        return a >= b ? a : b;
    }

    private static int max(int a, int b, int c) {
        return max(a, max(b, c));
    }

    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        List<Integer>[] adj = new List[n];
        HashMap<HD, Integer>[] dp = new HashMap[n];
        boolean[] processed = new boolean[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) dp[i] = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0] - 1, v = edge[1] - 1;
            adj[u].add(v);
            adj[v].add(u);
        }

        UsefulData usefulData = new UsefulData(adj, dp, processed);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);
        while (!stack.isEmpty()) {
            Integer node = stack.peekLast();
            if (processed[node]) {
                dfs(node, 0, usefulData.adj[node].size(), 0, 0, 1, usefulData);
                processed[node] = false;
                stack.pollLast();
            } else {
                processed[node] = true;
                for (Integer child : adj[node]) if (!processed[child]) stack.addLast(child);
            }
        }

        int[] ans = new int[n - 1];
        for (HashMap<HD, Integer> map : dp) {
            for (Map.Entry<HD, Integer> entry : map.entrySet()) {
                if (entry.getKey().diameter != 0) ans[entry.getKey().diameter - 1] += entry.getValue();
            }
        }
        return ans;
    }

    private static class UsefulData {
        private final List<Integer>[] adj;
        private final HashMap<HD, Integer>[] dp;
        private final boolean[] processed;

        public UsefulData(List<Integer>[] adj, HashMap<HD, Integer>[] dp, boolean[] processed) {
            this.adj = adj;
            this.dp = dp;
            this.processed = processed;
        }
    }

    private static class HD {
        final int height, diameter;

        public HD(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            HD hd = (HD) o;
            return height == hd.height && diameter == hd.diameter;
        }

        @Override
        public int hashCode() {
            return Objects.hash(height, diameter);
        }
    }
}
