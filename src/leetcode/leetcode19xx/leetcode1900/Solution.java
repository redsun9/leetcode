package leetcode.leetcode19xx.leetcode1900;

public class Solution {
    private static int[] dfs(int n, int round, int fp, int sp, int[][][][] dp) {
        int d = n + 1 - sp - fp;
        if (d == 0) return new int[]{round, round};
        if (d < 0) {
            int tmp = n + 1 - sp;
            sp = n + 1 - fp;
            fp = tmp;
            d = n + 1 - sp - fp;
        }
        if (dp[round - 1][fp - 1][sp - 1][0] == 0) {
            dp[round - 1][fp - 1][sp - 1][0] = Integer.MAX_VALUE;
            dp[round - 1][fp - 1][sp - 1][1] = Integer.MIN_VALUE;
            int middle = (n + 1) / 2;
            if (sp <= middle) {
                for (int n1 = 0; n1 < fp; n1++) {
                    for (int n2 = 0; n2 < sp - fp; n2++) {
                        int[] res = dfs(middle, round + 1, n1 + 1, n1 + n2 + 2, dp);
                        dp[round - 1][fp - 1][sp - 1][0] = Math.min(dp[round - 1][fp - 1][sp - 1][0], res[0]);
                        dp[round - 1][fp - 1][sp - 1][1] = Math.max(dp[round - 1][fp - 1][sp - 1][1], res[1]);
                    }
                }
            } else {
                for (int n1 = 0; n1 < fp; n1++) {
                    for (int d1 = 0; d1 < d; d1++) {
                        int[] res = dfs(middle, round + 1, n1 + 1, middle - d1 - (fp - 1 - n1), dp);
                        dp[round - 1][fp - 1][sp - 1][0] = Math.min(dp[round - 1][fp - 1][sp - 1][0], res[0]);
                        dp[round - 1][fp - 1][sp - 1][1] = Math.max(dp[round - 1][fp - 1][sp - 1][1], res[1]);
                    }
                }
            }
        }
        return dp[round - 1][fp - 1][sp - 1];
    }

    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        int i1 = Math.min(firstPlayer, secondPlayer);
        int i2 = Math.max(firstPlayer, secondPlayer);
        int[][][][] dp = new int[5][n + 1][n + 1][2];
        return dfs(n, 1, i1, i2, dp);
    }
}
