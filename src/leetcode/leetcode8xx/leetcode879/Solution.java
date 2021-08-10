package leetcode.leetcode8xx.leetcode879;

public class Solution {
    private static final int mod = 1_000_000_007;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int[][] dp = new int[minProfit + 1][n + 1];
        dp[0][0] = 1;
        int m = group.length;
        for (int i = 0; i < m; i++) {
            int g = group[i], p = profit[i];
            for (int p1 = minProfit; p1 >= 0; p1--) {
                int[] to = dp[Math.min(minProfit, p1 + p)], from = dp[p1];
                for (int n2 = n, n1 = n - g; n1 >= 0; n2--, n1--) {
                    to[n2] += from[n1];
                    if (to[n2] >= mod) to[n2] -= mod;
                }
            }
        }
        int ans = 0;
        for (int c : dp[minProfit]) {
            ans += c;
            if (ans >= mod) ans -= mod;
        }
        return ans;
    }
}
