package leetcode.leetcode10xx.leetcode1020;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    private static final int[] moves = {1, 0, -1, 0, 1};

    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (m <= 2 || n <= 2) return 0;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                queue.add(new int[]{i, 0});
                grid[i][0] = 0;
            }
            if (grid[i][n - 1] == 1) {
                queue.add(new int[]{i, n - 1});
                grid[i][n - 1] = 0;
            }
        }
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1) {
                queue.add(new int[]{0, j});
                grid[0][j] = 0;
            }
            if (grid[m - 1][j] == 1) {
                queue.add(new int[]{m - 1, j});
                grid[m - 1][j] = 0;
            }
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x1 = poll[0], y1 = poll[1];
            for (int k = 0; k < 4; k++) {
                int x2 = x1 + moves[k], y2 = y1 + moves[k + 1];
                if (x2 >= 0 && x2 < m && y2 >= 0 && y2 < n && grid[x2][y2] == 1) {
                    grid[x2][y2] = 0;
                    queue.add(new int[]{x2, y2});
                }
            }
        }
        int ans = 0;
        for (int[] row : grid) for (int val : row) if (val != 0) ans++;
        return ans;
    }
}
