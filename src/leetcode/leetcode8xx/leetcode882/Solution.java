package leetcode.leetcode8xx.leetcode882;

import java.util.*;

public class Solution {
    public int reachableNodes(int[][] edges, int m, int n) {
        List<int[]>[] neighbours = new List[n];
        for (int i = 0; i < n; i++) neighbours[i] = new LinkedList<>();
        for (int[] edge : edges) {
            neighbours[edge[0]].add(new int[]{edge[1], edge[2]});
            neighbours[edge[1]].add(new int[]{edge[0], edge[2]});
        }

        int[] visited = new int[n];
        Arrays.fill(visited, m + 1);
        visited[0] = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(ind -> visited[ind]));
        pq.add(0);
        while (!pq.isEmpty()) {
            Integer node = pq.poll();
            int dist = visited[node] + 1;
            for (int[] edge : neighbours[node]) {
                int newDist = dist + edge[1];
                if (newDist < visited[edge[0]]) {
                    pq.remove(edge[0]);
                    visited[edge[0]] = newDist;
                    pq.add(edge[0]);
                }
            }
        }
        int ans = 0;
        for (int dist : visited) if (dist <= m) ans++;
        for (int[] edge : edges) {
            int l = visited[edge[0]];
            int r = visited[edge[1]];
            int d = edge[2];
            if (l <= m && r <= m) ans += Math.min(d, m - l + m - r);
            else if (l <= m) ans += Math.min(d, m - l);
            else if (r <= m) ans += Math.min(d, m - r);
        }
        return ans;
    }
}
