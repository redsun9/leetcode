package leetcode.leetcode14xx.leetcode1406;

public class Solution {
    public String stoneGameIII(int[] a) {
        int n = a.length;
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int max = Integer.MIN_VALUE;
            int sum = 0;
            for (int j = i; j <= Math.min(i + 2, n - 1); j++) {
                sum += a[j];
                max = Math.max(max, sum - dp[j + 1]);
            }
            dp[i] = max;
        }
        if (dp[0] > 0) return "Alice";
        else if (dp[0] < 0) return "Bob";
        else return "Tie";
    }
}
