package leetcode.leetcode24xx.leetcode2428;

@SuppressWarnings("DuplicatedCode")
public class Solution {
    public int maxSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] a = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i + 1][j + 1] = a[i + 1][j] + a[i][j + 1] - a[i][j] + grid[i][j];
            }
        }

        int ans = 0;
        for (int top = 0, bottom = 3; bottom <= m; top++, bottom++) {
            for (int left = 0, right = 3; right <= n; left++, right++) {
                ans = Math.max(ans, a[bottom][right] - a[bottom][left] - a[top][right] + a[top][left] - grid[top + 1][left] - grid[top + 1][left + 2]);
            }
        }
        return ans;
    }
}
