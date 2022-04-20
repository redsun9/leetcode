package leetcode.leetcode8xx.leetcode808;

import java.util.Arrays;

public class Solution2 {
    public double soupServings(int n) {
        n = (n + 24) / 25;
        if (n >= 250) return 1;
        double[][] dp = new double[n + 1][n + 1];
        Arrays.fill(dp[0], 1);
        dp[0][0] = 0.5;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] += i >= 4 ? dp[i - 4][j] : 1;
                dp[i][j] += i >= 3 ? j >= 1 ? dp[i - 3][j - 1] : 0 : j >= 1 ? 1 : 0.5;
                dp[i][j] += i >= 2 ? j >= 2 ? dp[i - 2][j - 2] : 0 : j >= 2 ? 1 : 0.5;
                dp[i][j] += i >= 1 ? j >= 3 ? dp[i - 1][j - 3] : 0 : j >= 3 ? 1 : 0.5;
                dp[i][j] *= 0.25;
            }
        }
        return dp[n][n];
    }
}
