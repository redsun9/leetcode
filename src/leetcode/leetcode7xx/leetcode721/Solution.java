package leetcode.leetcode7xx.leetcode721;

import java.util.*;

public class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        TreeMap<String, Integer> map = new TreeMap<>();
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            List<String> list = accounts.get(i);
            int size = list.size();
            for (int j = 1; j < size; j++) {
                Integer oldValue = map.putIfAbsent(list.get(j), i);
                if (oldValue != null) uf.union(i, oldValue);
            }
        }
        HashMap<Integer, List<String>> merged = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int userId = uf.find(entry.getValue());
            merged.computeIfAbsent(userId, k -> {
                List<String> v = new ArrayList<>();
                v.add(accounts.get(userId).get(0));
                return v;
            }).add(entry.getKey());
        }
        return new ArrayList<>(merged.values());
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
