package leetcode.leetcode9xx.leetcode947;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int removeStones(int[][] stones) {
        HashMap<Integer, Integer> rowMap = new HashMap<>();
        HashMap<Integer, Integer> colMap = new HashMap<>();
        int n = stones.length;

        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            Integer prevForRow = rowMap.putIfAbsent(stones[i][0], i);
            if (prevForRow != null) uf.union(i, prevForRow);
            Integer prevForCol = colMap.putIfAbsent(stones[i][1], i);
            if (prevForCol != null) uf.union(i, prevForCol);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) set.add(uf.find(i));
        return n - set.size();
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
