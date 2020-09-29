package leetcode.leetcode8xx.leetcode813;

// O(k*n^2) - time
// O(n) - space
public class Solution {
    public double largestSumOfAverages(int[] a, int maxK) {
        int n = a.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) sum[i + 1] = sum[i] + a[i];
        double[] dp = new double[n + 1];
        for (int i = 1; i <= n; i++) dp[i] = sum[i] / (double) (i);
        for (int k = 2; k <= maxK; k++) {
            for (int j = n; j >= k; j--) {
                double max = 0;
                for (int i = k; i <= j; i++) {
                    max = Math.max(max, (sum[j] - sum[i - 1]) / (double) (j - i + 1) + dp[i - 1]);
                }
                dp[j] = max;
            }
        }
        return dp[n];
    }
}
