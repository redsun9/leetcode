package codeforces.contest1689;

import java.util.Scanner;
import java.util.Stack;

public class ProblemC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            int[][] edges = new int[n - 1][2];
            for (int i = n - 2; i >= 0; i--) {
                edges[i][0] = scanner.nextInt();
                edges[i][1] = scanner.nextInt();
            }
            System.out.println(solve(edges));
        }
    }

    private static int solve(int[][] edges) {
        int n = edges.length + 1;
        int[][] adj = new int[n + 1][3];
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];

            if (adj[u][0] == 0) adj[u][0] = v;
            else if (adj[u][1] == 0) adj[u][1] = v;
            else adj[u][2] = v;

            if (adj[v][0] == 0) adj[v][0] = u;
            else if (adj[v][1] == 0) adj[v][1] = u;
            else adj[v][2] = u;
        }

        int[] size = new int[n + 1];
        int[] dp = new int[n + 1];

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{1, 0});
        while (!stack.isEmpty()) {
            int[] peek = stack.peek();
            int u = peek[0], p = peek[1];
            boolean shouldWait = false;
            for (int v : adj[u]) {
                if (v != 0 && v != p && size[v] == 0) {
                    stack.push(new int[]{v, u});
                    shouldWait = true;
                }
            }
            if (!shouldWait) {
                stack.pop();

                int child1 = 0, child2 = 0;
                for (int v : adj[u]) {
                    if (v != 0 && v != p) {
                        if (child1 == 0) child1 = v;
                        else child2 = v;
                    }
                }
                if (child2 != 0) {
                    dp[u] = Math.max(size[child1] + dp[child2] - 1, size[child2] + dp[child1] - 1);
                    size[u] = 1 + size[child1] + size[child2];
                } else if (child1 != 0) {
                    dp[u] = size[child1] - 1;
                    size[u] = 1 + size[child1];
                } else {
                    dp[u] = 0;
                    size[u] = 1;
                }
            }
        }
        return dp[1];
    }
}
