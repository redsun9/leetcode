package leetcode.leetcode9xx.leetcode920;

@SuppressWarnings("DuplicatedCode")
public class Solution {
    private static final int mod = 1_000_000_007;

    public int numMusicPlaylists(int n, int goal, int k) {
        long[][] dp = new long[goal - k][n - k];
        dp[goal - k - 1][n - k - 1] = 1;
        for (int m = goal - k - 1; m > 0; m--) {
            for (int p = n - k - 1; p >= 0; p--) {
                if (p == 0) {
                    dp[m - 1][0] += (n - k) * dp[m][p];
                    if (dp[m - 1][0] >= mod) dp[m - 1][0] %= mod;
                } else {
                    dp[m - 1][p - 1] += dp[m][p];
                    if (dp[m - 1][p - 1] >= mod) dp[m - 1][p - 1] -= mod;
                    dp[m - 1][p] += dp[m][p] * (n - p - k);
                    if (dp[m - 1][p] >= mod) dp[m - 1][p] %= mod;
                }
            }
        }
        long ans = dp[0][0];
        for (int i = 2; i <= n; i++) ans = ans * i % mod;
        return (int) ans;
    }
}
