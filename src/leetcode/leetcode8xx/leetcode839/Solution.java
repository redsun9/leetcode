package leetcode.leetcode8xx.leetcode839;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (uf.find(i) != uf.find(j) && same(strs[i], strs[j])) uf.union(i, j);
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) set.add(uf.find(i));
        return set.size();
    }

    private static boolean same(String s1, String s2) {
        int n = s1.length();
        int diff = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (++diff == 3) return false;
            }
        }
        return true;
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
