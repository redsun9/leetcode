package leetcode.leetcode10xx.leetcode1000;

public class Solution {
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n - 1) % (k - 1) != 0) return -1;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; i++) s[i + 1] = s[i] + stones[i];

        int[][] dp = new int[n][n];
        for (int m = k; m <= n; ++m) {
            for (int i = 0; i + m <= n; ++i) {
                int j = i + m - 1;
                int min = Integer.MAX_VALUE;
                for (int mid = i; mid < j; mid += k - 1) min = Math.min(min, dp[i][mid] + dp[mid + 1][j]);
                if ((j - i) % (k - 1) == 0) min += s[j + 1] - s[i];
                dp[i][j] = min;
            }
        }
        return dp[0][n - 1];
    }
}
