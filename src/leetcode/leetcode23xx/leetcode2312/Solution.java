package leetcode.leetcode23xx.leetcode2312;

import static java.lang.Math.max;

public class Solution {
    public long sellingWood(int m, int n, int[][] prices) {
        long[][] dp = new long[m + 1][n + 1];
        for (int[] price : prices) {
            int h = price[0], w = price[1];
            dp[h][w] = max(dp[h][w], price[2]);
        }
        for (int h = 1; h <= m; h++) {
            for (int w = 1; w <= n; w++) {
                long[] row = dp[h];
                long max = row[w];
                for (int h1 = h / 2, h2 = h - h1; h1 >= 1; h1--, h2++) max = max(max, dp[h1][w] + dp[h2][w]);
                for (int w1 = w / 2, w2 = w - w1; w1 >= 1; w1--, w2++) max = max(max, row[w1] + row[w2]);
                row[w] = max;
            }
        }
        return dp[m][n];
    }
}
