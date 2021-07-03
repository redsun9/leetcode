package leetcode.leetcode4xx.leetcode407;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static final int[] moves = {1, 0, -1, 0, 1};

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(c -> c.height));
        boolean[][] visited = new boolean[m][n];

        //add border cells
        for (int i = 0; i < m; i++) {
            visited[i][0] = true;
            visited[i][n - 1] = true;
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            pq.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
        }
        for (int j = 0; j < n; j++) {
            visited[0][j] = true;
            visited[m - 1][j] = true;
            pq.offer(new Cell(0, j, heightMap[0][j]));
            pq.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
        }

        int ans = 0;
        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            for (int k = 0; k < 4; k++) {
                int x1 = cell.row + moves[k];
                int y1 = cell.col + moves[k + 1];
                if (x1 >= 0 && x1 < m && y1 >= 0 && y1 < n && !visited[x1][y1]) {
                    visited[x1][y1] = true;
                    ans += Math.max(0, cell.height - heightMap[x1][y1]);
                    pq.offer(new Cell(x1, y1, Math.max(cell.height, heightMap[x1][y1])));
                }
            }
        }
        return ans;
    }


    private static class Cell {
        int row, col, height;

        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
}
