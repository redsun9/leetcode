package leetcode.leetcode11xx.leetcode1162;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    private static final int[] moves = {1, 0, -1, 0, 1};

    public int maxDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        int x, y;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        x = i + moves[k];
                        y = j + moves[k + 1];
                        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 0) {
                            grid[x][y] = 2;
                            queue.add(new int[]{x, y});
                        }
                    }
                }
            }
        }
        if (queue.isEmpty()) return -1;
        int ans = 2;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int i = poll[0], j = poll[1];
            ans = grid[i][j];
            for (int k = 0; k < 4; k++) {
                x = i + moves[k];
                y = j + moves[k + 1];
                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 0) {
                    grid[x][y] = ans + 1;
                    queue.add(new int[]{x, y});
                }
            }
        }
        return ans - 1;
    }
}
