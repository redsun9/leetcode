package leetcode.leetcode4xx.leetcode417;

import java.util.*;

public class Solution {
    private static final int[] moves = {1, 0, -1, 0, 1};

    private static void dfs(PriorityQueue<int[]> pq, boolean[][] v, int[][] h, int m, int n) {
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int x1 = poll[1], y1 = poll[2], val = poll[0];
            for (int k = 0; k < 4; k++) {
                int x2 = x1 + moves[k], y2 = y1 + moves[k + 1];
                if (x2 >= 0 && x2 < m && y2 >= 0 && y2 < n && !v[x2][y2] && h[x2][y2] >= val) {
                    pq.offer(new int[]{h[x2][y2], x2, y2});
                    v[x2][y2] = true;
                }
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        PriorityQueue<int[]> pq1 = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        PriorityQueue<int[]> pq2 = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        boolean[][] first = new boolean[m][n];
        boolean[][] second = new boolean[m][n];

        for (int i = 0; i < n; i++) pq1.offer(new int[]{heights[0][i], 0, i});
        for (int i = 0; i < n; i++) pq2.offer(new int[]{heights[m - 1][i], m - 1, i});
        Arrays.fill(first[0], true);
        Arrays.fill(second[m - 1], true);

        for (int i = 0; i < m; i++) {
            pq1.offer(new int[]{heights[i][0], i, 0});
            pq2.offer(new int[]{heights[i][n - 1], i, n - 1});
            first[i][0] = true;
            second[i][n - 1] = true;
        }

        dfs(pq1, first, heights, m, n);
        dfs(pq2, second, heights, m, n);

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (first[i][j] && second[i][j]) ans.add(List.of(i, j));
            }
        }
        return ans;
    }
}
