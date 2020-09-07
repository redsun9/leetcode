package leetcode.leetcode15xx.leetcode1579;

public class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind a = new UnionFind(n);
        UnionFind b = new UnionFind(n);
        int number1 = n - 1, number2 = n - 1;
        int ans = edges.length;
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (a.find(edge[1] - 1) != a.find(edge[2] - 1)) {
                    number1--;
                    number2--;
                    a.union(edge[1] - 1, edge[2] - 1);
                    b.union(edge[1] - 1, edge[2] - 1);
                    ans--;
                }
            }
        }
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (a.find(edge[1] - 1) != a.find(edge[2] - 1)) {
                    number1--;
                    a.union(edge[1] - 1, edge[2] - 1);
                    ans--;
                }
            } else if (edge[0] == 2) {
                if (b.find(edge[1] - 1) != b.find(edge[2] - 1)) {
                    number2--;
                    b.union(edge[1] - 1, edge[2] - 1);
                    ans--;
                }
            }
        }
        return number1 == 0 && number2 == 0 ? ans : -1;
    }

    private static class UnionFind {
        private final int[] p;
        private final int[] rank;

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
