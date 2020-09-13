package leetcode.leetcode15xx.leetcode1584;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int ans = 0;
        UnionFind uf = new UnionFind(n);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(xy -> xy[2]));

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                pq.add(new int[]{i, j, Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])});
            }
        }
        n--;
        while (!pq.isEmpty() && n != 0) {
            int[] xy = pq.poll();
            if (uf.find(xy[0]) != uf.find(xy[1])) {
                uf.union(xy[0], xy[1]);
                ans += xy[2];
                n--;
            }
        }
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
