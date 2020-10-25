package leetcode.leetcode16xx.leetcode1632;


import java.util.*;

public class Solution {
    public int[][] matrixRankTransform(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        UnionFind uf = new UnionFind(m * n);
        for (int i = 0; i < m; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (map.containsKey(matrix[i][j])) {
                    uf.union(map.get(matrix[i][j]), i * n + j);
                } else map.put(matrix[i][j], i * n + j);
            }
        }

        for (int j = 0; j < n; j++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < m; i++) {
                if (map.containsKey(matrix[i][j])) {
                    uf.union(map.get(matrix[i][j]), i * n + j);
                } else map.put(matrix[i][j], i * n + j);
            }
        }
        int[] maxRankByRow = new int[m], maxRankByCol = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingInt((int[] x) -> x[0]).thenComparingInt(x -> x[1])
        );
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                pq.add(new int[]{matrix[i][j], uf.find(i * n + j), i, j});
        while (!pq.isEmpty()) {
            int group = pq.peek()[1];
            int max = 0;
            List<int[]> list = new ArrayList<>();
            while (!pq.isEmpty() && pq.peek()[1] == group) {
                int[] poll = pq.poll();
                max = Math.max(max, maxRankByRow[poll[2]]);
                max = Math.max(max, maxRankByCol[poll[3]]);
                list.add(poll);
            }
            max++;
            for (int[] node : list) {
                matrix[node[2]][node[3]] = max;
                maxRankByRow[node[2]] = max;
                maxRankByCol[node[3]] = max;
            }
        }
        return matrix;
    }


    private static class UnionFind {
        private final int n;
        private final int p[], rank[];

        UnionFind(int n) {
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
