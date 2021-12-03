package leetcode.leetcode20xx.leetcode2088;

public class Solution {
    public int countPyramids(int[][] grid) {
        int m = grid.length, n = grid[0].length, ans = 0, tmp;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 0) continue;
                tmp = min(grid[i - 1][j - 1], grid[i - 1][j], grid[i - 1][j + 1]);
                ans += tmp;
                grid[i][j] = tmp + 1;
            }
        }
        for (int j = 0; j < n; j++) {
            if (grid[m - 1][j] != 0) grid[m - 1][j] = 1;
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 0) continue;
                tmp = min(grid[i + 1][j - 1], grid[i + 1][j], grid[i + 1][j + 1]);
                ans += tmp;
                grid[i][j] = tmp + 1;
            }
        }
        return ans;
    }

    private static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
