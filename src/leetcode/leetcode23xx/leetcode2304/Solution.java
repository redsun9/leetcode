package leetcode.leetcode23xx.leetcode2304;

import java.util.Arrays;

public class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length, n = grid[0].length;
        int[] prev = Arrays.copyOf(grid[0], n);
        int[] next = new int[n];
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) min = Math.min(min, prev[k] + moveCost[grid[i - 1][k]][j]);
                next[j] = min + grid[i][j];
            }
            int[] tmp = prev;
            prev = next;
            next = tmp;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) ans = Math.min(ans, prev[i]);
        return ans;
    }
}
