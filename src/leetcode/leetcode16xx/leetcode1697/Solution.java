package leetcode.leetcode16xx.leetcode1697;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int numberOfEdges = edgeList.length;
        int numberOfQueries = queries.length;

        List<Integer> edgeIndices = IntStream.range(0, numberOfEdges).boxed()
                .sorted(Comparator.comparingInt(x -> edgeList[x][2]))
                .collect(Collectors.toList());
        List<Integer> queryIndices = IntStream.range(0, numberOfQueries).boxed()
                .sorted(Comparator.comparingInt(x -> queries[x][2]))
                .collect(Collectors.toList());
        UnionFind uf = new UnionFind(n);
        boolean[] ans = new boolean[numberOfQueries];
        int curEdgeIndex = 0;
        for (Integer queryIndex : queryIndices) {
            int[] query = queries[queryIndex];
            while (curEdgeIndex < numberOfEdges && edgeList[edgeIndices.get(curEdgeIndex)][2] < query[2]) {
                uf.union(edgeList[edgeIndices.get(curEdgeIndex)][0], edgeList[edgeIndices.get(curEdgeIndex)][1]);
                curEdgeIndex++;
            }
            ans[queryIndex] = uf.find(query[0]) == uf.find(query[1]);
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
