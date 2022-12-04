package leetcode.leetcode24xx.leetcode2477;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@SuppressWarnings("unchecked")
public class Solution {
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] road : roads) {
            int u = road[0], v = road[1];
            adj[u].add(v);
            adj[v].add(u);
        }
        boolean[] visited = new boolean[n];
        int[] count = new int[n];
        long[] dp = new long[n];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while (!stack.isEmpty()) {
            int u = stack.peek();
            if (!visited[u]) {
                visited[u] = true;
                for (Integer v : adj[u]) if (!visited[v]) stack.push(v);
            } else {
                visited[u] = false;
                stack.pop();
                int cnt = 1;
                long val = 0;
                for (Integer v : adj[u]) {
                    if (!visited[v]) {
                        cnt += count[v];
                        val += dp[v] + (count[v] + seats - 1) / seats;
                    }
                }
                count[u] = cnt;
                dp[u] = val;
            }
        }
        return dp[0];
    }
}
