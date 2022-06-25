package leetcode.leetcode23xx.leetcode2316;

import java.util.HashMap;

public class Solution {
    public long countPairs(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) uf.union(edge[0], edge[1]);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = uf.find(i);
            map.compute(a, (k, v) -> v == null ? 1 : v + 1);
        }
        long ans = n * (n - 1L);
        for (Integer value : map.values()) ans -= value * (value - 1L);
        return ans / 2;
    }


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
