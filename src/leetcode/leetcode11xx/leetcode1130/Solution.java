package leetcode.leetcode11xx.leetcode1130;

public class Solution {
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][] max = new int[n][n];
        for (int i = 0; i < n; i++) {
            max[i][i] = arr[i];
            for (int j = i + 1; j < n; j++) {
                max[i][j] = Math.max(max[i][j - 1], arr[j]);
            }
        }
        int[][] dp = new int[n][n];
        for (int d = 1; d <= n - 1; d++) {
            for (int start = 0, end = start + d; end < n; start++, end++) {
                int minVal = Integer.MAX_VALUE;
                for (int mid = start; mid < end; mid++) {
                    minVal = Math.min(minVal, dp[start][mid] + dp[mid + 1][end] + max[start][mid] * max[mid + 1][end]);
                }
                dp[start][end] = minVal;
            }
        }
        return dp[0][n - 1];
    }
}
