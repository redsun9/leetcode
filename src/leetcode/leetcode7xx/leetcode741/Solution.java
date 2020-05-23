package leetcode.leetcode7xx.leetcode741;

import java.util.Arrays;

public class Solution {
    public int cherryPickup(int[][] grid) {
        final int n = grid.length;
        // we start two walkers
        //and by diagonals
        //i1+j1 = i2+j2
        //n*n - dp
        int[][] prev = new int[n][n];
        int[][] curr = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(prev[i], -1);
            Arrays.fill(curr[i], -1);
        }
        prev[0][0] = grid[0][0];
        for (int s = 1; s < 2 * n - 1; s++) {
            int start = Math.max(0, s - n + 1);
            int end = Math.min(s, n - 1);
            for (int x1 = start, y1 = s - x1; x1 <= end; x1++, y1--) {
                for (int x2 = x1, y2 = y1; x2 <= end; x2++, y2--) {
                    if (grid[x1][y1] < 0 || grid[x2][y2] < 0) {
                        curr[x1][x2] = -1;
                        continue;
                    }
                    int max = -1;
                    if (y1 > 0 && y2 > 0) max = Math.max(max, prev[x1][x2]);
                    if (x1 > 0) max = Math.max(max, prev[x1 - 1][x2]);
                    if (x2 > x1) max = Math.max(max, prev[x1][x2 - 1]);
                    if (x1 > 0 && x2 > 0) max = Math.max(max, prev[x1 - 1][x2 - 1]);
                    if (max >= 0) max += grid[x1][y1] + (x1 != x2 ? grid[x2][y2] : 0);
                    curr[x1][x2] = max;
                }
            }
            int[][] tmp = prev;
            prev = curr;
            curr = tmp;
        }
        return Math.max(0, prev[n - 1][n - 1]);
    }
}
