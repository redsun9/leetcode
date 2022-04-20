package leetcode.leetcode8xx.leetcode808;

public class Solution {
    public double soupServings(int n) {
        n = (n + 24) / 25;
        if (n >= 250) return 1;
        double[][] dp = new double[n + 1][n + 1];
        return dfs(n, n, dp);
    }

    private static double dfs(int a, int b, double[][] dp) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1;
        if (b <= 0) return 0;
        if (dp[a][b] > 0) return dp[a][b];
        dp[a][b] = 0.25 * (dfs(a - 4, b, dp) + dfs(a - 3, b - 1, dp) + dfs(a - 2, b - 2, dp) + dfs(a - 1, b - 3, dp));
        return dp[a][b];
    }
}
