package leetcode.leetcode8xx.leetcode847;

import java.util.Arrays;

public class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], n - 1);
        for (int i = 0; i < n; i++) dist[i][i] = 0;
        for (int i = 0; i < n; i++) for (int j : graph[i]) dist[i][j] = 1;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < n; k++) {
                    dist[i][k] = Math.min(dist[i][k], dist[i][j] + dist[j][k]);
                }
            }
        }

        int maxMask = 1 << n;
        int[][] dp = new int[maxMask][n];

        for (int mask = 0; mask < maxMask; mask++) {
            if ((mask & (mask - 1)) == 0) continue;
            for (int i = 0; i < n; i++) {
                if ((mask >> i & 1) == 0) continue;
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < n; j++) {
                    if (j == i || (mask >> j & 1) == 0) continue;
                    min = Math.min(min, dp[mask ^ (1 << i)][j] + dist[i][j]);
                }
                dp[mask][i] = min;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) ans = Math.min(ans, dp[maxMask - 1][i]);
        return ans;
    }
}
