package leetcode.leetcode9xx.leetcode940;

public class Solution {
    private static final int p = 1_000_000_007;

    public int distinctSubseqII(String s) {
        int n = s.length();
        long[] dp = new long[26];
        long total = 0;
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            long prev = dp[c];
            dp[c] = total + 1;
            total = 2L * total - prev + 1;
            if (total >= p) total %= p;
            if (total < 0) total += p;
        }
        return (int) total;
    }
}
