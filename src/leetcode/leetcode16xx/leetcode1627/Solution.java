package leetcode.leetcode16xx.leetcode1627;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        int m = queries.length;
        List<Boolean> ans = new ArrayList<>(m);
        if (threshold == 0) {
            for (int i = 0; i < m; i++) ans.add(true);
            return ans;
        }
        UnionFind uf = new UnionFind(n);
        for (int u = threshold + 1; u <= n / 2; u++) {
            for (int v = 2 * u; v <= n; v += u) uf.union(u - 1, v - 1);
        }
        for (int[] query : queries) ans.add(uf.find(query[0] - 1) == uf.find(query[1] - 1));
        return ans;
    }


    private static class UnionFind {
        private final int n;
        private final int p[], rank[];

        public UnionFind(int n) {
            this.n = n;
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
