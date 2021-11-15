package leetcode.leetcode20xx.leetcode2076;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        UnionFind uf = new UnionFind(n);
        for (int[] restriction : restrictions) uf.forbid(restriction[0], restriction[1]);

        int m = requests.length;
        boolean[] ans = new boolean[m];
        for (int i = 0; i < m; i++) {
            int u = requests[i][0], v = requests[i][1];
            if (uf.allowed(u, v)) {
                uf.union(u, v);
                ans[i] = true;
            }
        }
        return ans;
    }


    @SuppressWarnings({"DuplicatedCode", "SuspiciousNameCombination", "unchecked"})
    private static class UnionFind {
        private final Set<Integer>[] r;
        private final int[] p, rank;

        public UnionFind(int n) {
            rank = new int[n];
            p = new int[n];
            r = new Set[n];
            for (int i = 0; i < n; i++) p[i] = i;
        }

        void forbid(int x, int y) {
            if (r[x] == null) r[x] = new HashSet<>();
            if (r[y] == null) r[y] = new HashSet<>();
            r[x].add(y);
            r[y].add(x);
        }

        boolean allowed(int x, int y) {
            x = find(x);
            y = find(y);
            if (x == y || r[x] == null || r[y] == null) return true;
            if (r[x].size() < r[y].size()) {
                for (Integer u : r[x]) if (find(u) == y) return false;
            } else {
                for (Integer u : r[y]) if (find(u) == x) return false;
            }
            return true;
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

            Set<Integer> unionSet;
            if (r[x] == null) unionSet = r[y];
            else if (r[y] == null) unionSet = r[x];
            else if (r[x].size() < r[y].size()) {
                r[y].addAll(r[x]);
                unionSet = r[y];
            } else {
                r[x].addAll(r[y]);
                unionSet = r[x];
            }
            r[x] = null;
            r[y] = null;

            if (rank[x] < rank[y]) {
                p[x] = y;
                r[y] = unionSet;
            } else {
                p[y] = x;
                r[x] = unionSet;
                if (rank[x] == rank[y]) ++rank[x];
            }
        }
    }
}
