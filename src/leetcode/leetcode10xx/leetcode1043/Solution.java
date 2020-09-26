package leetcode.leetcode10xx.leetcode1043;

public class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int max = 0;
            int tmp = 0;
            for (int d = 0, j = i; d < k && j >= 0; d++, j--) {
                max = Math.max(max, arr[j]);
                tmp = Math.max(tmp, dp[j] + max * (d + 1));
            }
            dp[i + 1] = tmp;
        }
        return dp[n];
    }
}
