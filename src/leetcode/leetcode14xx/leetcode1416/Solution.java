package leetcode.leetcode14xx.leetcode1416;

public class Solution {
    public static final int m = 1_000_000_007;

    public int numberOfArrays(String s, int k) {
        char[] chars = s.toCharArray();
        int n = s.length();
        long[] dp = new long[n + 1];
        dp[0] = 1;
        int d = Integer.toString(k).length();
        long[] min = new long[d];
        min[0] = 1;
        for (int i = 1; i < d; i++) {
            min[i] = min[i - 1] * 10;
        }
        long[] tmp = new long[d + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = d; j > 0; j--) {
                tmp[j] = tmp[j - 1] * 10 + chars[i - 1] - '0';
                if (tmp[j] >= min[j - 1] && tmp[j] <= k) dp[i] += dp[i - j];
            }
            dp[i] %= m;
        }
        return (int) dp[n];
    }
}
