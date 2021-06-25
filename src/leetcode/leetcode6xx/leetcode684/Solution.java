package leetcode.leetcode6xx.leetcode684;

public class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            if (uf.find(edge[0] - 1) == uf.find(edge[1] - 1)) return edge;
            uf.union(edge[0] - 1, edge[1] - 1);
        }
        return null;
    }


    private static class UnionFind {
        private final int n;
        private final int p[], rank[];

        public UnionFind(int n) {
            this.n = n;
            rank = new int[n];
            p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = i;
            }
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
            if (rank[x] < rank[y])
                p[x] = y;
            else {
                p[y] = x;
                if (rank[x] == rank[y])
                    ++rank[x];
            }
        }
    }
}
