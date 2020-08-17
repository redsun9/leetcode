package leetcode.leetcode12xx.leetcode1254;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    private static final int[] moves = {0, 1, 0, -1, 0};

    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) removeLand(grid, i, 0, m, n);
            if (grid[i][n - 1] == 0) removeLand(grid, i, n - 1, m, n);
        }
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 0) removeLand(grid, 0, j, m, n);
            if (grid[m - 1][j] == 0) removeLand(grid, m - 1, j, m, n);
        }

        int ans = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 0) {
                    removeLand(grid, i, j, m, n);
                    ans++;
                }
            }
        }
        return ans;
    }

    private static void removeLand(int[][] grid, int i, int j, int m, int n) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (grid[poll[0]][poll[1]] == 0) {
                grid[poll[0]][poll[1]] = 1;
                for (int k = 0; k < 4; k++) {
                    int nextI = poll[0] + moves[k];
                    int nextJ = poll[1] + moves[k + 1];
                    if (
                            nextI >= 0 && nextI < m &&
                                    nextJ >= 0 && nextJ < n &&
                                    grid[nextI][nextJ] == 0
                    ) queue.add(new int[]{nextI, nextJ});
                }
            }
        }
    }
}
