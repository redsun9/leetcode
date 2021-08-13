package binsearch.binsearch656;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int solve(String[] genes) {
        int n = genes.length, m = genes[0].length();
        UnionFind uf = new UnionFind(n);
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String gene = genes[i];
            long key = 0;
            for (int j = 0; j < m; j++) {
                long c = switch (gene.charAt(j)) {
                    case 'A' -> 0;
                    case 'C' -> 1;
                    case 'G' -> 2;
                    case 'T' -> 3;
                    default -> throw new IllegalArgumentException();
                };
                key |= c << (2 * j);
            }
            for (int j = 0; j < m; j++) {
                long mut = key & ~(3L << (2 * j)); // clear bits for j
                for (long c = 0; c < 4; c++) {
                    Integer index = map.get(mut | c << (2 * j));
                    if (index != null) uf.union(i, index);
                }
            }
            map.put(key, i);
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) set.add(uf.find(i));
        return set.size();
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
