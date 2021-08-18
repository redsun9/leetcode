package leetcode.leetcode6xx.leetcode685;

import java.util.Arrays;

public class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        int node = -1, first = 0, second = 0;
        for (int[] edge : edges) {
            int u = edge[0] - 1, v = edge[1] - 1;
            if (parent[v] == -1) parent[v] = u;
            else {
                node = v;
                first = parent[v];
                second = u;
            }
        }

        UnionFind uf = new UnionFind(n);
        if (node == -1) {
            // search last edge of cycle
            for (int[] edge : edges) {
                int u = edge[0] - 1, v = edge[1] - 1;
                if (uf.find(u) == uf.find(v)) return edge;
                uf.union(u, v);
            }
            return null;
        } else {
            //check which edge to the node with two parents creates a cycle
            for (int[] edge : edges) {
                int u = edge[0] - 1, v = edge[1] - 1;
                if (v == node) continue;
                uf.union(u, v);
            }

            if (uf.find(node) == uf.find(first)) return new int[]{first + 1, node + 1};
            else return new int[]{second + 1, node + 1};
        }
    }

    @SuppressWarnings({"DuplicatedCode", "SuspiciousNameCombination"})
    private static class UnionFind {
        private final int[] p, rank;

        public UnionFind(int n) {
            rank = new int[n];
            p = new int[n];
            for (int i = 0; i < n; i++) p[i] = i;
        }

        int find(int x) {
            if (x == p[x]) return x;
            else {
                p[x] = find(p[x]);
                return p[x];
            }
        }

        void union(int x, int y) {
            x = find(x);
            y = find(y);
            if (x == y) return;
            if (rank[x] < rank[y]) p[x] = y;
            else {
                p[y] = x;
                if (rank[x] == rank[y]) ++rank[x];
            }
        }
    }
}
