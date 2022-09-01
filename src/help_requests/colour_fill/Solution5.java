package help_requests.colour_fill;

// O(m*n) - space
// O(m*n*invAckerman(m*n)) - time

public class Solution5 {
    public static int numberOfFills(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        UnionFind uf = new UnionFind(m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && mat[i - 1][j] == mat[i][j]) uf.union((i - 1) * n + j, i * n + j);
                if (j > 0 && mat[i][j - 1] == mat[i][j]) uf.union(i * n + j - 1, i * n + j);
            }
        }
        int ans = 0;
        for (int i = 0, k = 0; i < m; i++) {
            for (int j = 0; j < n; j++, k++) {
                if (uf.find(k) == k) ans++;
            }
        }
        return ans;
    }

    private static class UnionFind {
        private final int[] p, rank;

        public UnionFind(int n) {
            rank = new int[n];
            p = new int[n];
            for (int i = 0; i < n; i++) p[i] = i;
        }

        public int find(int x) {
            if (x == p[x]) return x;
            else {
                p[x] = find(p[x]);
                return p[x];
            }
        }

        public void union(int x, int y) {
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
