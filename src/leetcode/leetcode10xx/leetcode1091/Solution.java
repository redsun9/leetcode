package leetcode.leetcode10xx.leetcode1091;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) return -1;
        if (n <= 2) return n;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        grid[0][0] = 1;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x1 = poll[0], y1 = poll[1], val = grid[x1][y1] + 1;
            for (int i = -1; i <= 1; i++) {
                int x2 = x1 + i;
                if (x2 < 0 || x2 >= n) continue;
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0) continue;
                    int y2 = y1 + j;
                    if (x2 == n - 1 && y2 == n - 1) return val;
                    if (y2 >= 0 && y2 < n && grid[x2][y2] == 0) {
                        grid[x2][y2] = val;
                        queue.add(new int[]{x2, y2});
                    }
                }
            }
        }
        return -1;
    }
}
