package leetcode.leetcode9xx.leetcode994;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static final int[] moves = {-1, 0, 1, 0, -1};

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        if (n == 0) return 0;
        int left = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) left++;
                else if (grid[i][j] == 2) queue.add(new int[]{i, j});
            }
        }
        int ans = 0;
        while (left != 0 && !queue.isEmpty()) {
            ans++;
            int currGeneration = queue.size();
            for (int i = 0; i < currGeneration; i++) {
                int[] poll = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int nextI = poll[0] + moves[k];
                    int nextJ = poll[1] + moves[k + 1];
                    if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n && grid[nextI][nextJ] == 1) {
                        grid[nextI][nextJ] = 2;
                        left--;
                        queue.add(new int[]{nextI, nextJ});
                    }
                }
            }
        }
        return left == 0 ? ans : -1;

    }
}
