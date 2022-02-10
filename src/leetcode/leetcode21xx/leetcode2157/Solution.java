package leetcode.leetcode21xx.leetcode2157;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] groupStrings(String[] words) {
        int n = words.length;
        UnionFind uf = new UnionFind(n);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = words[i];
            int mask = 0, m = s.length();
            for (int j = 0; j < m; j++) mask |= 1 << (s.charAt(j) - 'a');
            Integer prev = map.putIfAbsent(mask, i);
            if (prev != null) uf.union(prev, i);

            for (int j = 0; j < 26; j++) {
                if ((mask >> j & 1) == 1) {
                    prev = map.putIfAbsent(mask ^ 1 << j, i);
                    if (prev != null) uf.union(prev, i);
                }
            }
        }

        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < n; i++) count.compute(uf.find(i), (k, v) -> v == null ? 1 : v + 1);
        int[] ans = new int[2];
        for (Integer size : count.values()) ans[1] = Math.max(ans[1], size);
        ans[0] = count.size();
        return ans;
    }


    @SuppressWarnings({"DuplicatedCode", "SuspiciousNameCombination"})
    private static class UnionFind {
        final int[] p, rank;

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
