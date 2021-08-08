package leetcode.leetcode9xx.leetcode959;

public class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        UnionFind uf = new UnionFind(2 * n * (n + 1));
        int s = n * (n + 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) != '/') {
                    uf.union(i * (n + 1) + j, s + (i + 1) * n + j);
                    uf.union(i * (n + 1) + j + 1, s + i * n + j);
                }
                if (grid[i].charAt(j) != '\\') {
                    uf.union(i * (n + 1) + j, s + i * n + j);
                    uf.union(i * (n + 1) + j + 1, s + (i + 1) * n + j);
                }
            }
        }
        int ans = 0;
        for (int i = 2 * n * (n + 1) - 1; i >= 0; i--) if (uf.find(i) == i) ans++;
        return ans;
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
