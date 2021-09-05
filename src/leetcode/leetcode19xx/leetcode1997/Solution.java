package leetcode.leetcode19xx.leetcode1997;

public class Solution {
    private static final int p = 1_000_000_007;

    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int n = nextVisit.length;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] * 2 - dp[nextVisit[i - 1]] + 2;
            if (dp[i] >= p) dp[i] -= p;
            else if (dp[i] < 0) dp[i] += p;
        }
        return dp[n - 1];
    }
}
