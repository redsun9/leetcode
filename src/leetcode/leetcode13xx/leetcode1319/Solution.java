package leetcode.leetcode13xx.leetcode1319;

public class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;

        UnionFind unionFind = new UnionFind(n);
        for (int[] connection : connections) {
            int x = connection[0];
            int y = connection[1];
            unionFind.union(x, y);
        }
        int ans = 0;
        int[] p = unionFind.p;
        for (int i = 0; i < p.length; i++) {
            if (p[i] == i) ans++;
        }
        return ans - 1;
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
