package facebook.hacker2021.qual.ProblemC1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

@SuppressWarnings({"unchecked", "UnnecessarySemicolon"})
public class Main {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/facebook/hacker2021/qual/ProblemC1/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/facebook/hacker2021/qual/ProblemC1/output.txt");
                PrintStream printer = new PrintStream(fos);
        ) {
            int numberOfTests = scanner.nextInt();
            for (int test = 1; test <= numberOfTests; test++) {
                int n = scanner.nextInt();
                int[] g = new int[n];
                for (int i = 0; i < n; i++) g[i] = scanner.nextInt();

                int[][] edges = new int[n - 1][2];
                for (int i = 0; i < n - 1; i++) {
                    edges[i][0] = scanner.nextInt() - 1;
                    edges[i][1] = scanner.nextInt() - 1;
                }
                int ans = solve(g, edges);
                printer.println("Case #" + test + ": " + ans);
            }
        }
    }

    private static int solve(int[] g, int[][] edges) {
        int n = g.length;
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        int[] dp = new int[n];
        boolean[] processed = new boolean[n];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int u = queue.peekLast();
            if (processed[u]) {
                processed[u] = false;
                queue.pollLast();
                int max = 0;
                for (Integer v : adj[u]) if (!processed[v]) max = Math.max(max, dp[v]);
                dp[u] = g[u] + max;

            } else {
                processed[u] = true;
                for (Integer v : adj[u]) if (!processed[v]) queue.addLast(v);
            }
        }

        if (adj[0].size() <= 1) return dp[0];
        int max1 = 0, max2 = 0;
        for (Integer v : adj[0]) {
            if (dp[v] > max2) {
                if (dp[v] > max1) {
                    max2 = max1;
                    max1 = dp[v];
                } else max2 = dp[v];
            }
        }
        return max1 + max2 + g[0];
    }
}
