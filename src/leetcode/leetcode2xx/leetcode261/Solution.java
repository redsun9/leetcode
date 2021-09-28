package leetcode.leetcode2xx.leetcode261;

public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n - 1 != edges.length) return false;
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            if (uf.find(edge[0]) == uf.find(edge[1])) return false;
            uf.union(edge[0], edge[1]);
        }
        return true;
    }


    @SuppressWarnings({"DuplicatedCode", "SuspiciousNameCombination"})
    private static class UnionFind {
        private final int[] p, rank;

        UnionFind(int n) {
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
