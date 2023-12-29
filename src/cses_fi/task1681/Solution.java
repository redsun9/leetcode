package cses_fi.task1681;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
    A game has n levels, connected by m teleporters, and your task is to get from level 1 to level n.
    The game has been designed so that there are no directed cycles in the underlying graph.
    In how many ways can you complete the game?
 */
@SuppressWarnings("DuplicatedCode")
public class Solution {
    private static final int mod = 1_000_000_007;

    public static long numberOfWays(int n, int[][] teleporters) {
        List<Integer>[] destinations = new List[n];
        int[] unprocessedDependencies = new int[n];
        int[] dp = new int[n];
        for (int[] teleporter : teleporters) {
            int u = teleporter[0] - 1, v = teleporter[1] - 1;
            unprocessedDependencies[v]++;
            if (destinations[u] == null) destinations[u] = new ArrayList<>();
            destinations[u].add(v);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        dp[0] = 1;
        for (int i = 0; i < n; i++) if (unprocessedDependencies[i] == 0) queue.offer(i);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            if (destinations[u] == null) continue;
            for (Integer v : destinations[u]) {
                dp[v] += dp[u];
                if (dp[v] >= mod) dp[v] -= mod;
                if (--unprocessedDependencies[v] == 0) queue.offer(v);
            }
        }
        return dp[n - 1];
    }
}
