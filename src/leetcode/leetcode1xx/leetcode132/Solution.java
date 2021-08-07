package leetcode.leetcode1xx.leetcode132;

public class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) dp[i] = i;
        for (int i = 0; i < n; i++) {
            int i1 = i, i2 = i;
            while (i1 >= 0 && i2 < n && s.charAt(i1) == s.charAt(i2)) {
                dp[i2 + 1] = Math.min(dp[i2 + 1], dp[i1] + 1);
                i1--;
                i2++;
            }
            i1 = i;
            i2 = i + 1;
            while (i1 >= 0 && i2 < n && s.charAt(i1) == s.charAt(i2)) {
                dp[i2 + 1] = Math.min(dp[i2 + 1], dp[i1] + 1);
                i1--;
                i2++;
            }
        }
        return dp[n] - 1;
    }
}
