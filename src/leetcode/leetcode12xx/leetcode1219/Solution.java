package leetcode.leetcode12xx.leetcode1219;

import static java.lang.Math.max;

/*
    simple backtrack
 */
public class Solution {
    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                ans = Math.max(ans, dfs(grid, i, j, m, n));
        return ans;
    }

    private static int dfs(int[][] grid, int i, int j, int m, int n) {
        if (grid[i][j] == 0) return 0;
        int result = 0;
        int temp = grid[i][j];
        grid[i][j] = 0;
        if (i > 0) result = max(result, temp + dfs(grid, i - 1, j, m, n));
        if (j > 0) result = max(result, temp + dfs(grid, i, j - 1, m, n));
        if (i < m - 1) result = max(result, temp + dfs(grid, i + 1, j, m, n));
        if (j < n - 1) result = max(result, temp + dfs(grid, i, j + 1, m, n));
        grid[i][j] = temp;
        return result;
    }
}
