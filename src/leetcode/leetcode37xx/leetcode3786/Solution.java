package leetcode.leetcode37xx.leetcode3786;

import java.util.*;
import java.util.function.BiFunction;

public class Solution {
    @SuppressWarnings("unchecked")
    public long interactionCosts(int n, int[][] edges, int[] group) {
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        boolean[] visited = new boolean[n];
        Map<Integer, Node>[] dp = new Map[n];
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, -1, 0});
        while (!stack.isEmpty()) {
            int[] peek = stack.peek();
            int u = peek[0], p = peek[1], h = peek[2];
            if (!visited[u]) {
                visited[u] = true;
                for (Integer v : adj[u]) if (v != p) stack.push(new int[]{v, u, h + 1});
            } else {
                stack.pop();

                int biggestMapIdx = -1, biggestMapSize = -1;
                for (Integer v : adj[u]) {
                    if (v != p) {
                        if (dp[v].size() > biggestMapSize) {
                            biggestMapSize = dp[v].size();
                            biggestMapIdx = v;
                        }
                    }
                }
                if (biggestMapIdx != -1) dp[u] = dp[biggestMapIdx];
                else dp[u] = new HashMap<>();

                BiFunction<Node, Node, Node> mergeFunction = (a, b) -> merge(a, b, h);
                dp[u].merge(group[u], new Node(1, h, 0, 0), mergeFunction);
                for (Integer v : adj[u]) {
                    if (v != p && v != biggestMapIdx) {
                        for (Map.Entry<Integer, Node> vEntry : dp[v].entrySet()) {
                            dp[u].merge(vEntry.getKey(), vEntry.getValue(), mergeFunction);
                        }
                    }
                }
            }
        }

        long ans = 0;
        for (Node value : dp[0].values()) ans += value.t;
        return ans;
    }

    private record Node(long c, long h, long s, long t) {
    }

    private static Node merge(Node a, Node b, int h) {
        long c = a.c + b.c;
        long s = a.s + a.c * (a.h - h) + b.s + b.c * (b.h - h);
        long t = a.t + b.t + a.s * b.c + b.s * a.c + a.c * b.c * (a.h - h + b.h - h);
        return new Node(c, h, s, t);
    }
}
