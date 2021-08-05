package leetcode.leetcode11xx.leetcode1192;

import java.util.*;

@SuppressWarnings("unchecked")
public class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (List<Integer> connection : connections) {
            int u = connection.get(0), v = connection.get(1);
            adj[u].add(v);
            adj[v].add(u);
        }

        Set<List<Integer>> ans = new HashSet<>();
        int counter = 0;
        int[] times = new int[n], low = new int[n];
        Deque<int[]> stack = new ArrayDeque<>();
        stack.add(new int[]{0, -1});
        while (!stack.isEmpty()) {
            int[] peek = stack.peekLast();
            int u = peek[0], pre = peek[1];
            if (times[u] == 0) {
                times[u] = ++counter;
                low[u] = counter;
                for (Integer v : adj[u]) {
                    if (v == pre) continue;
                    if (times[v] == 0) stack.addLast(new int[]{v, u});
                }
            } else {
                stack.pollLast();
                for (Integer v : adj[u]) {
                    if (v == pre) continue;
                    low[u] = Math.min(low[u], low[v]);
                    low[u] = Math.min(low[u], times[v]);
                    if (low[v] > times[u]) ans.add(List.of(u, v));
                }
            }
        }
        return new ArrayList<>(ans);
    }
}
