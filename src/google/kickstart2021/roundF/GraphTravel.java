package google.kickstart2021.roundF;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class GraphTravel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = Integer.parseInt(scanner.nextLine());
        for (int testIndex = 1; testIndex <= numberOfTests; ++testIndex) {
            String[] parts = scanner.nextLine().split(" ");
            int n = Integer.parseInt(parts[0]);
            int m = Integer.parseInt(parts[1]);
            int k = Integer.parseInt(parts[2]);

            int[][] rooms = new int[n][3];
            for (int i = 0; i < n; i++) {
                parts = scanner.nextLine().split(" ");
                rooms[i][0] = Integer.parseInt(parts[0]);
                rooms[i][1] = Integer.parseInt(parts[1]);
                rooms[i][2] = Integer.parseInt(parts[2]);
            }

            int[][] edges = new int[m][2];
            for (int i = 0; i < m; i++) {
                parts = scanner.nextLine().split(" ");
                edges[i][0] = Integer.parseInt(parts[0]);
                edges[i][1] = Integer.parseInt(parts[1]);
            }

            System.out.println("Case #" + testIndex + ": " + solve(rooms, edges, k));
        }
    }

    static long solve(int[][] rooms, int[][] edges, int k) {
        int n = rooms.length;
        int[] adj = new int[n];

        for (int[] edge : edges) {
            adj[edge[0]] |= 1 << edge[1];
            adj[edge[1]] |= 1 << edge[0];
        }

        int maxKey = 1 << n;
        long[] sum = new long[maxKey];
        for (int i = 0, max = 2; i < n; i++, max *= 2) {
            for (int from = 0, to = 1 << i; to < max; from++, to++) {
                sum[to] = sum[from] + rooms[i][2];
            }
        }

        long[] cache = new long[maxKey];
        for (int i = 0; i < n; i++) cache[1 << i] = 2L;
        long ans = 0;

        for (int mask = 1; mask < maxKey; mask++) {
            if (sum[mask] == k) ans += dfs(rooms, adj, k, n, mask, cache);
        }
        return ans;
    }

    static long dfs(
            int[][] rooms, int[] adj, int k, int n, int mask, long[] cache
    ) {
        if (cache[mask] == 0) {
            long tmp = 1;
            for (int i = 0; i < n; i++) {
                if (
                        (mask >>> i & 1) == 1 && (adj[i] & mask) != 0 &&
                                k - rooms[i][2] >= rooms[i][0] && k - rooms[i][2] <= rooms[i][1]
                ) tmp += dfs(rooms, adj, k - rooms[i][2], n, mask ^ 1 << i, cache);
            }
            cache[mask] = tmp;
        }
        return cache[mask] - 1;
    }
}
