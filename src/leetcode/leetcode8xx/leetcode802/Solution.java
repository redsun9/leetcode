package leetcode.leetcode8xx.leetcode802;

import java.util.*;

@SuppressWarnings("unchecked")
public class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer>[] incomingEdges = new List[n];
        int[] outcomingCounters = new int[n];
        for (int i = 0; i < n; i++) incomingEdges[i] = new ArrayList<>();
        for (int u = 0; u < n; u++) {
            for (int v : graph[u]) {
                outcomingCounters[u]++;
                incomingEdges[v].add(u);
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) if (outcomingCounters[i] == 0) queue.add(i);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            ans.add(v);
            for (Integer u : incomingEdges[v]) {
                if (--outcomingCounters[u] == 0) queue.add(u);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
