package leetcode.leetcode39xx.leetcode3938;

public class Solution {
    public int maxScore(int[][] grid) {
        int ans = Integer.MIN_VALUE, m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            int curr = grid[i][0];
            for (int j = 1; j < n; j++) {
                ans = Math.max(ans, curr + grid[i][j]);
                if (i > 0 && i < m - 1 && j < n - 1) ans = Math.max(ans, grid[i][j]);
                curr = Math.max(curr + grid[i][j], grid[i][j]);
            }
        }
        for (int j = 0; j < n; j++) {
            int curr = grid[0][j];
            for (int i = 1; i < m; i++) {
                ans = Math.max(ans, curr + grid[i][j]);
                if (i < m - 1 && j > 0 && j < n - 1) ans = Math.max(ans, grid[i][j]);
                curr = Math.max(curr + grid[i][j], grid[i][j]);
            }
        }
        return ans;
    }
}
