package leetcode.leetcode11xx.leetcode1140;

public class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        for (int i = n - 2; i >= 0; i--) piles[i] += piles[i + 1];
        return dfs(piles, n, 0, 1, new int[n][n]);
    }

    private int dfs(int[] sum, int n, int pos, int m, int[][] dp) {
        if (pos + 2 * m >= n) return sum[pos];
        if (dp[pos][m] > 0) return dp[pos][m];

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= 2 * m; i++) {
            ans = Math.min(ans, dfs(sum, n, pos + i, Math.max(i, m), dp));
        }
        ans = sum[pos] - ans;
        dp[pos][m] = ans;
        return ans;
    }
}
