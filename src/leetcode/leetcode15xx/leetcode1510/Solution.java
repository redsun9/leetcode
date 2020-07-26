package leetcode.leetcode15xx.leetcode1510;

public class Solution {
    public boolean winnerSquareGame(int n) {
        Boolean[] dp = new Boolean[n + 1];
        dp[0] = false;
        return winnerSquareGame(n, dp);
    }

    public boolean winnerSquareGame(int n, Boolean[] dp) {
        if (dp[n] != null) return dp[n];
        boolean ans = false;
        for (int i = 1; i * i <= n; i++) {
            if (!winnerSquareGame(n - i * i, dp)) {
                ans = true;
                break;
            }
        }
        dp[n] = ans;
        return ans;
    }
}
