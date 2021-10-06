package leetcode.leetcode3xx.leetcode317;

import java.util.ArrayDeque;
import java.util.Queue;

@SuppressWarnings("ConstantConditions")
public class Solution {
    private static final int[] moves = {1, 0, -1, 0, 1};

    /**
     * @param grid: the 2D grid
     * @return the shortest distance
     */
    public int shortestDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        int counter = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            int[] row = grid[i];
            for (int j = 0; j < n; j++) {
                if (row[j] == 1) {
                    queue.add(i);
                    queue.add(j);
                    queue.add(0);
                    while (!queue.isEmpty()) {
                        int x1 = queue.poll(), y1 = queue.poll(), d = queue.poll() + 1;
                        for (int k = 0; k < 4; k++) {
                            int x2 = x1 + moves[k], y2 = y1 + moves[k + 1];
                            if (x2 >= 0 && x2 < m && y2 >= 0 && y2 < n && grid[x2][y2] == counter) {
                                grid[x2][y2]--;
                                dp[x2][y2] += d;
                                queue.add(x2);
                                queue.add(y2);
                                queue.add(d);
                            }
                        }
                    }
                    counter--;
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) if (grid[i][j] == counter) ans = Math.min(ans, dp[i][j]);
        return ans;
    }
}
