package leetcode.leetcode24xx.leetcode2435;

public class Solution {
    private static final int p = 1_000_000_007;

    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][k];
        dp[0][0][grid[0][0] % k] = 1;
        for (int j = 0, sum = 0; j < n; j++) {
            sum += grid[0][j];
            if (sum >= k) sum %= k;
            dp[0][j][sum] = 1;
        }
        for (int i = 0, sum = 0; i < m; i++) {
            sum += grid[i][0];
            if (sum >= k) sum %= k;
            dp[i][0][sum] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int num = grid[i][j] % k;
                for (int d = 0; d < k; d++) {
                    int sum = num + d;
                    if (sum >= k) sum -= k;
                    int var = dp[i][j - 1][d] + dp[i - 1][j][d];
                    if (var >= p) var -= p;
                    dp[i][j][sum] = var;
                }
            }
        }
        return dp[m - 1][n - 1][0];
    }
}
