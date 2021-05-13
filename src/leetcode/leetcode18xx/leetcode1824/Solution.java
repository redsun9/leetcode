package leetcode.leetcode18xx.leetcode1824;

public class Solution {
    private static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int[] dp = {1, 0, 1};
        for (int obstacle : obstacles) {
            if (obstacle == 0) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            } else {
                dp[obstacle - 1] = n;
                for (int i = 0; i < 3; i++) {
                    if (i == obstacle - 1) continue;
                    for (int j = 0; j < 3; j++) {
                        if (j == obstacle - 1) continue;
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }
        return min(dp[0], dp[1], dp[2]);
    }
}
