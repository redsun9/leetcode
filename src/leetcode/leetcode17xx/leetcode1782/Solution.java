package leetcode.leetcode17xx.leetcode1782;

import java.util.*;

public class Solution {
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        int[] cnt = new int[n];
        HashMap<Pair, Integer> map = new HashMap<>();
        for (int[] edge : edges) {
            int u = Math.min(edge[0], edge[1]) - 1;
            int v = Math.max(edge[0], edge[1]) - 1;
            cnt[u]++;
            cnt[v]++;
            Pair pair = new Pair(u, v);
            map.put(pair, map.getOrDefault(pair, 0) + 1);
        }
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) indices[i] = i;
        Arrays.sort(indices, Comparator.comparingInt(i -> cnt[i]));

        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int query = queries[i];
            int l = 0, r = n - 1;
            int tmp = 0;
            while (l < r) {
                int threshold = query - cnt[indices[l]];
                while (l < r && cnt[indices[r]] > threshold) r--;
                tmp += n - r - 1;
                l++;
            }
            tmp += (n - l) * (n - l - 1) / 2;

            for (Map.Entry<Pair, Integer> entry : map.entrySet()) {
                if (
                        cnt[entry.getKey().u] + cnt[entry.getKey().v] > query &&
                                cnt[entry.getKey().u] + cnt[entry.getKey().v] - entry.getValue() <= query
                ) tmp--;
            }
            ans[i] = tmp;
        }
        return ans;
    }

    private static class Pair {
        private final int u, v;

        public Pair(int u, int v) {
            this.u = u;
            this.v = v;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return u == pair.u && v == pair.v;
        }

        @Override
        public int hashCode() {
            return Objects.hash(u, v);
        }
    }
}
