package leetcode.leetcode3xx.leetcode343;

public class Solution {
    int[] dp = new int[59];

    public int integerBreak(int n) {
        if (n <= 3) return n - 1;
        for (int i = 1; i <= 4; i++) dp[i] = i;
        for (int i = 5; i <= 58; i++) dp[i] = Math.max(dp[i - 2] * 2, dp[i - 3] * 3);
        return dp[n];
    }
}
