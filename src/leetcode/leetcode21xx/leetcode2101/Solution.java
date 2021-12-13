package leetcode.leetcode21xx.leetcode2101;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        boolean[][] adj = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            int[] u = bombs[i];
            long x1 = u[0], y1 = u[1];
            long r2 = u[2] * (long) u[2];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int[] v = bombs[j];
                long d = (x1 - v[0]) * (x1 - v[0]) + (y1 - v[1]) * (y1 - v[1]);
                adj[i][j] = r2 >= d;
            }
        }
        int ans = 1;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>(n);
        for (int start = 0; start < n; start++) {
            Arrays.fill(visited, false);
            visited[start] = true;
            int tmp = 1;
            queue.add(start);

            while (!queue.isEmpty()) {
                boolean[] row = adj[queue.poll()];
                for (int v = 0; v < n; v++) {
                    if (row[v] && !visited[v]) {
                        tmp++;
                        visited[v] = true;
                        queue.add(v);
                    }
                }
            }
            ans = Math.max(ans, tmp);
        }
        return ans;
    }
}
