package leetcode.leetcode6xx.leetcode695;

import java.util.ArrayDeque;
import java.util.Queue;

@SuppressWarnings("ConstantConditions")
public class Solution {
    public static final int[] moves = {1, 0, -1, 0, 1};

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        int x1, x2, y1, y2, tmp;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                tmp = 1;
                grid[i][j] = 0;
                queue.add(i);
                queue.add(j);
                while (!queue.isEmpty()) {
                    x1 = queue.poll();
                    y1 = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        x2 = x1 + moves[k];
                        y2 = y1 + moves[k + 1];
                        if (x2 >= 0 && x2 < m && y2 >= 0 && y2 < n && grid[x2][y2] == 1) {
                            grid[x2][y2] = 0;
                            tmp++;
                            queue.add(x2);
                            queue.add(y2);
                        }
                    }
                }
                ans = Math.max(ans, tmp);
            }
        }
        return ans;
    }
}
