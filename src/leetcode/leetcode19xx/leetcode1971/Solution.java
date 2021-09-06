package leetcode.leetcode19xx.leetcode1971;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@SuppressWarnings({"DuplicatedCode", "unchecked"})
public class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        if (start == end) return true;
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (Integer v : adj[u]) {
                if (end == v) return true;
                if (visited[v]) continue;
                visited[v] = true;
                queue.offer(v);
            }
        }
        return false;
    }
}
