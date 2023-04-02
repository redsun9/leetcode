package leetcode.leetcode25xx.leetcode2556;

public class Solution {
    public boolean isPossibleToCutPath(int[][] grid) {
        return markPath(grid) || markPath(grid);
    }

    private static boolean markPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        grid[0][0] = 2;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                if (i > 0 && grid[i - 1][j] == 2) grid[i][j] = 2;
                if (j > 0 && grid[i][j - 1] == 2) grid[i][j] = 2;
            }
        }
        if (grid[m - 1][n - 1] != 2) return true;

        int i1 = m - 1, j1 = n - 1;
        while (i1 > 0 || j1 > 0) {
            grid[i1][j1] = 0;
            if (i1 > 0 && grid[i1 - 1][j1] == 2) i1--;
            else if (j1 > 0 && grid[i1][j1 - 1] == 2) j1--;
        }
        grid[m - 1][n - 1] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                grid[i][j] = 1;
            }
        }
        return false;
    }
}
