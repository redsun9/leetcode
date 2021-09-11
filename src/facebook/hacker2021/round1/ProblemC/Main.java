package facebook.hacker2021.round1.ProblemC;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

@SuppressWarnings("DuplicatedCode")
public class Main {
    private static final int p = 1_000_000_007;
    private static final int maxC = 20;

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/facebook/hacker2021/round1/ProblemC/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/facebook/hacker2021/round1/ProblemC/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            int t = Integer.parseInt(scanner.nextLine());
            for (int test = 1; test <= t; test++) {
                int n = Integer.parseInt(scanner.nextLine());
                List<int[]>[] adj = new List[n];
                for (int j = 0; j < n; j++) adj[j] = new ArrayList<>();
                for (int j = 0; j < n - 1; j++) {
                    String s = scanner.nextLine();
                    String[] parts = s.split(" ");
                    int u = Integer.parseInt(parts[0]) - 1;
                    int v = Integer.parseInt(parts[1]) - 1;
                    int c = Integer.parseInt(parts[2]);
                    adj[u].add(new int[]{v, c, j});
                    adj[v].add(new int[]{u, c, j});
                }
                int ans = solve(adj);
                printer.println("Case #" + test + ": " + ans);
            }
        }
    }

    static int solve(List<int[]>[] adj) {
        int n = adj.length;
        int[][] nodeCount = new int[n][maxC + 1];
        int[][][] edgeCount = new int[n - 1][2][maxC + 1];

        boolean[] visited = new boolean[n];

        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(0);

        while (!stack.isEmpty()) {
            int u = stack.peekLast();
            if (visited[u]) {
                visited[u] = false;
                stack.pollLast();
                for (int[] edge : adj[u]) {
                    int v = edge[0];
                    if (!visited[v]) {
                        int edgeC = edge[1];
                        int edgeIndex = edge[2];
                        for (int c = 1; c <= maxC; c++) {
                            nodeCount[u][Math.min(c, edgeC)] += nodeCount[v][c];
                            edgeCount[edgeIndex][1][Math.min(c, edgeC)] += nodeCount[v][c];
                        }
                        nodeCount[u][edgeC]++;
                        edgeCount[edgeIndex][1][edgeC]++;
                    }
                }
            } else {
                visited[u] = true;
                for (int[] edge : adj[u]) {
                    if (!visited[edge[0]]) stack.addLast(edge[0]);
                }
            }
        }

        stack.add(0);
        while (!stack.isEmpty()) {
            int u = stack.pollLast();
            visited[u] = true;
            for (int[] edge : adj[u]) {
                int v = edge[0];
                if (!visited[v]) {
                    stack.addLast(edge[0]);
                    int edgeC = edge[1];
                    int edgeIndex = edge[2];
                    for (int c = 1; c <= maxC; c++) edgeCount[edgeIndex][0][Math.min(c, edgeC)] += nodeCount[u][c];
                    for (int c = 1; c <= maxC; c++) edgeCount[edgeIndex][0][Math.min(c, edgeC)] -= nodeCount[v][c];
                    for (int c = 1; c <= edgeC; c++) nodeCount[v][c] += edgeCount[edgeIndex][0][c];
                }
            }
        }

        long total = 0;
        for (int[] count : nodeCount) for (int i = 1; i <= maxC; i++) total += (long) i * count[i];
        total %= p;
        total *= reverse(2);
        total %= p;

        long ans = 1;
        for (int i = 0; i < n - 1; i++) {
            long totalEdge = 0;
            for (int c1 = 1; c1 <= maxC; c1++) {
                for (int c2 = 1; c2 <= maxC; c2++) {
                    totalEdge += (long) Math.min(c1, c2) * edgeCount[i][0][c1] * edgeCount[i][1][c2];
                }
            }
            totalEdge %= p;
            totalEdge = total - totalEdge;
            totalEdge %= p;
            if (totalEdge < 0) totalEdge += p;
            ans *= totalEdge;
            ans %= p;
        }

        return (int) ans;
    }

    private static int reverse(int a) {
        int t = 0, newT = 1, r = p, newR = a, q, tmp;
        while (newR != 0) {
            q = r / newR;
            tmp = t - q * newT;
            t = newT;
            newT = tmp;
            tmp = r - q * newR;
            r = newR;
            newR = tmp;
        }
        if (r > 1) return -1;
        if (t < 0) t += p;
        return t;
    }
}
