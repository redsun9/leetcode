package leetcode.leetcode14xx.leetcode1473;

import java.util.Arrays;

public class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        //i - house, j-colour, k - current number of neighborhoods
        int[][][] dp = new int[m][n][target];
        for (int[][] a : dp) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }
        if (houses[0] == 0) for (int j = 0; j < n; j++) dp[0][j][0] = cost[0][j];
        else dp[0][houses[0] - 1][0] = 0;

        for (int i = 1; i < m; i++) {
            int minColor = houses[i] == 0 ? 0 : houses[i] - 1;
            int maxColor = houses[i] == 0 ? n - 1 : houses[i] - 1;
            for (int j2 = minColor; j2 <= maxColor; j2++) {
                for (int target2 = 0; target2 < target; target2++) {
                    int tmp = Integer.MAX_VALUE;
                    //same color
                    if (dp[i - 1][j2][target2] >= 0) tmp = Math.min(tmp, dp[i - 1][j2][target2]);
                    if (target2 > 0) {
                        //different color
                        for (int j1 = 0; j1 < n; j1++) {
                            if (j1 != j2 && dp[i - 1][j1][target2 - 1] >= 0)
                                tmp = Math.min(tmp, dp[i - 1][j1][target2 - 1]);
                        }
                    }
                    if (tmp != Integer.MAX_VALUE) dp[i][j2][target2] = tmp + (houses[i] == 0 ? cost[i][j2] : 0);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            if (dp[m - 1][j][target - 1] >= 0) ans = Math.min(ans, dp[m - 1][j][target - 1]);
        }
        return ans != Integer.MAX_VALUE ? ans : -1;
    }
}
