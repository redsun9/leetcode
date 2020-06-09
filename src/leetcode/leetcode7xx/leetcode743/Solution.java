package leetcode.leetcode7xx.leetcode743;

import java.util.*;

public class Solution {
    private static final int INF = 1_000_000_000;

    public int networkDelayTime(int[][] times, int n, int k) {
        if (n == 1) return 0;
        List<int[]>[] adj = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList<>();
        }
        for (int[] time : times) {
            adj[time[0] - 1].add(time);
        }
        int[] dp = new int[n];
        Arrays.fill(dp, INF);
        dp[k - 1] = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(k - 1);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            int cur = dp[poll];
            for (int[] edge : adj[poll]) {
                if (dp[edge[1] - 1] > cur + edge[2]) {
                    dp[edge[1] - 1] = cur + edge[2];
                    queue.offer(edge[1] - 1);
                }
            }
        }
        int ans = 0;
        for (int val : dp) ans = Math.max(ans, val);
        return ans < INF ? ans : -1;
    }
}
