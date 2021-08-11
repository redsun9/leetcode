package leetcode.leetcode8xx.leetcode818;

public class Solution {
    public int racecar(int target) {
        return dfs(target, new int[2 * target + 1]);
    }

    private static int dfs(int t, int[] dp) {
        if (dp[t] == 0) {
            int n = (int) (Math.log(t) / Math.log(2)) + 1;
            if (1 << n == t + 1) dp[t] = n;
            else {
                int x = 1 << (n - 1);
                int min = dfs((1 << n) - t - 1, dp) + n + 1;
                for (int i = 0, j = 1; i < n - 1; i++, j <<= 1) min = Math.min(min, dfs(t - x + j, dp) + n + i + 1);
                dp[t] = min;
            }
        }
        return dp[t];
    }
}
