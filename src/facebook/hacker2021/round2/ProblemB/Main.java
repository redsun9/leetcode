package facebook.hacker2021.round2.ProblemB;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

@SuppressWarnings({"UnnecessarySemicolon", "ConstantConditions", "unchecked"})
public class Main {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/facebook/hacker2021/round2/ProblemB/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/facebook/hacker2021/round2/ProblemB/output.txt");
                PrintStream printer = new PrintStream(fos);
        ) {
            int numberOfTests = Integer.parseInt(scanner.nextLine());
            for (int test = 1; test <= numberOfTests; test++) {
                int n = Integer.parseInt(scanner.nextLine());

                int[][] edges = new int[n - 1][2];
                for (int i = 0; i < n - 1; i++) {
                    String[] parts = scanner.nextLine().split(" ");
                    edges[i][0] = Integer.parseInt(parts[0]) - 1;
                    edges[i][1] = Integer.parseInt(parts[1]) - 1;
                }
                int[] freq = new int[n];
                for (int i = 0; i < n; i++) freq[i] = scanner.nextInt();
                scanner.nextLine();
                int ans = solve(edges, freq);

                printer.println("Case #" + test + ": " + ans);
            }
        }
    }

    private static int solve(int[][] edges, int[] freq) {
        int n = freq.length;
        int ans = 0;
        List<int[]>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int[] edge = edges[i];
            adj[edge[0]].add(new int[]{edge[1], i});
            adj[edge[1]].add(new int[]{edge[0], i});
        }


        int[] depth = new int[n];
        int[][] parent = new int[n][2];
        boolean[] needed = new boolean[n - 1];

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, -1, 0, -1});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int u = poll[0];
            int p = poll[1];
            int d = poll[2];
            int e = poll[3];
            depth[u] = d;
            parent[u][0] = p;
            parent[u][1] = e;
            for (int[] v : adj[u]) {
                if (v[0] == p) continue;
                queue.add(new int[]{v[0], u, d + 1, v[1]});
            }
        }

        HashMap<Integer, List<Integer>> countFreq = new HashMap<>();
        for (int i = 0; i < n; i++) countFreq.computeIfAbsent(freq[i], k -> new ArrayList<>()).add(i);

        //curr, from, depth
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingInt((int[] x) -> -x[2]).thenComparingInt(x -> x[0])
        );

        for (List<Integer> list : countFreq.values()) {
            if (list.size() == 1) continue;
            for (Integer u : list) pq.add(new int[]{u, u, depth[u]});
            while (true) {
                int[] poll = pq.poll();
                while (!pq.isEmpty() && pq.peek()[0] == poll[0]) {
                    int[] poll2 = pq.poll();
                    int tmp = poll2[1], nxt;
                    while (tmp != poll2[0]) {
                        if (!needed[parent[tmp][1]]) {
                            needed[parent[tmp][1]] = true;
                            ans++;
                        }
                        nxt = parent[tmp][0];
                        parent[tmp][0] = poll[0];
                        tmp = nxt;
                    }
                }

                if (pq.isEmpty()) {
                    int tmp = poll[1], nxt;
                    while (tmp != poll[0]) {
                        if (!needed[parent[tmp][1]]) {
                            needed[parent[tmp][1]] = true;
                            ans++;
                        }
                        nxt = parent[tmp][0];
                        parent[tmp][0] = poll[0];
                        tmp = nxt;
                    }
                    break;
                }
                poll[0] = parent[poll[0]][0];
                poll[2] = depth[poll[0]];
                pq.offer(poll);
            }
        }
        return n - 1 - ans;
    }
}
