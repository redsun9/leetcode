package tinkoff.circular_travel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("unchecked")
public class Solution {
    private final static int p = 998244353;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        int[][] edges = new int[m][2];
        for (int i = 0; i < m; i++) {
            edges[i][0] = scanner.nextInt() - 1;
            edges[i][1] = scanner.nextInt() - 1;
        }
        System.out.println(solve(edges, n, k));
    }

    static int solve(int[][] removedEdges, int n, int k) {
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] edge : removedEdges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        long[] prev = new long[n], next = new long[n], tmp;
        prev[0] = 1;
        long prevTotal = 1, nextTotal;

        while (k-- > 0) {
            nextTotal = 0;
            for (int u = 0; u < n; u++) {
                next[u] = prevTotal - prev[u];
                for (int v : adj[u]) next[u] -= prev[v];
                next[u] %= p;
                if (next[u] < 0) next[u] += p;
                nextTotal += next[u];
            }
            nextTotal %= p;
            if (nextTotal < 0) nextTotal += p;

            prevTotal = nextTotal;
            tmp = prev;
            prev = next;
            next = tmp;
        }
        return (int) prev[0];
    }
}
