package leetcode.leetcode23xx.leetcode2368;

import java.util.BitSet;

public class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        UnionFind uf = new UnionFind(n);
        BitSet bitSet = new BitSet(n);
        for (int node : restricted) bitSet.set(node);
        for (int[] edge : edges) {
            if (bitSet.get(edge[0]) || bitSet.get(edge[1])) continue;
            uf.union(edge[0], edge[1]);
        }

        int ans = 1, group = uf.find(0);
        for (int i = 1; i < n; i++) {
            if (!bitSet.get(i) && uf.find(i) == group) ans++;
        }
        return ans;
    }

    @SuppressWarnings({"DuplicatedCode", "SuspiciousNameCombination"})
    private static class UnionFind {
        private final int[] p, rank;

        public UnionFind(int n) {
            rank = new int[n];
            p = new int[n];
            for (int i = 0; i < n; i++) p[i] = i;
        }

        public int find(int x) {
            if (x == p[x]) return x;
            else {
                p[x] = find(p[x]);
                return p[x];
            }
        }

        public void union(int x, int y) {
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
