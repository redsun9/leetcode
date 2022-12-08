package leetcode.leetcode24xx.leetcode2492;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@SuppressWarnings("unchecked")
public class Solution {
    public int minScore(int n, int[][] roads) {
        List<int[]>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] road : roads) {
            int u = road[0] - 1, v = road[1] - 1, d = road[2];
            adj[u].add(new int[]{v, d});
            adj[v].add(new int[]{u, d});
        }

        int ans = Integer.MAX_VALUE;
        boolean[] meet = new boolean[n];
        meet[0] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int[] road : adj[u]) {
                ans = Math.min(ans, road[1]);
                if (meet[road[0]]) continue;
                meet[road[0]] = true;
                queue.offer(road[0]);
            }
        }
        if (meet[n - 1]) return ans;
        else return -1;

    }
}
