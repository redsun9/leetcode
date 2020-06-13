package leetcode.leetcode14xx.leetcode1478;

import java.util.Arrays;

public class Solution {
    public int minDistance(int[] houses, int K) {
        int n = houses.length;
        if (n <= K) return 0;
        Arrays.sort(houses);
        int[][] sum = new int[n][n];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = sum[i - 1][j] + houses[i] - houses[(i + j) / 2];
                sum[i][j] = tmp;
                sum[j][i] = tmp;
            }
        }
        int[][] dp = new int[K][n];
        System.arraycopy(sum[0], 0, dp[0], 0, n);
        for (int k = 1; k < K; k++) {
            for (int i = k; i < n; i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < i; j++) {
                    min = Math.min(min, dp[k - 1][j] + sum[j + 1][i]);
                }
                dp[k][i] = min;
            }
        }
        return dp[K - 1][n - 1];
    }
}
