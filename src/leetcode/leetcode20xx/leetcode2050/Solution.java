package leetcode.leetcode20xx.leetcode2050;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@SuppressWarnings("unchecked")
public class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        int[] indegree = new int[n];
        int[] endTime = new int[n];
        for (int[] relation : relations) {
            adj[relation[0] - 1].add(relation[1] - 1);
            indegree[relation[1] - 1]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) if (indegree[i] == 0) queue.add(i);

        int ans = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            endTime[u] += time[u];
            int s = endTime[u];
            ans = Math.max(ans, s);
            for (Integer v : adj[u]) {
                endTime[v] = Math.max(endTime[v], s);
                if (--indegree[v] == 0) queue.add(v);
            }
        }
        return ans;
    }
}
