package leetcode.leetcode3xx.leetcode375;

public class Solution {
    public int getMoneyAmount(int n) {
        if (n <= 3) return n - 1;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i - 2][i] = i - 1;
        }
        for (int d = 3; d <= n; d++) {
            for (int i = 0, j = d; j <= n; i++, j++) {
                int tmp = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    tmp = Math.min(tmp, k + 1 + Math.max(dp[i][k], dp[k + 1][j]));
                }
                dp[i][j] = tmp;
            }
        }
        return dp[0][n];
    }
}
