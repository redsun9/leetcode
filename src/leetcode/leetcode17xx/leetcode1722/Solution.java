package leetcode.leetcode17xx.leetcode1722;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        UnionFind uf = new UnionFind(n);
        for (int[] pair : allowedSwaps) uf.union(pair[0], pair[1]);
        Map<Pair, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int groupId = uf.find(i);
            map.compute(new Pair(groupId, source[i]), (k, v) -> v == null ? 1 : v + 1);
            map.compute(new Pair(groupId, target[i]), (k, v) -> v == null ? -1 : v - 1);
        }
        int ans = 0;
        for (Integer value : map.values()) ans += Math.abs(value);
        return ans / 2;
    }

    private static class Pair {
        final int groupId, value;

        public Pair(int groupId, int value) {
            this.groupId = groupId;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return groupId == pair.groupId && value == pair.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(groupId, value);
        }
    }

    @SuppressWarnings("SuspiciousNameCombination")
    private static class UnionFind {
        private final int[] p, rank;

        public UnionFind(int n) {
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
