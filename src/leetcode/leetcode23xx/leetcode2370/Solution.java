package leetcode.leetcode23xx.leetcode2370;

public class Solution {
    private static final int ALPHA_SIZE = 26;

    public int longestIdealString(String s, int k) {
        int n = s.length();
        if (k >= ALPHA_SIZE - 1) return n;
        int[] dp = new int[ALPHA_SIZE]; // dp[i] = length of the longest special subsequence ending with i
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            int max = 0;
            for (int j = Math.max(0, c - k); j <= Math.min(ALPHA_SIZE - 1, c + k); j++) max = Math.max(max, dp[j]);
            dp[c] = max + 1;
        }

        int ans = 0;
        for (int i = 0; i < ALPHA_SIZE; i++) ans = Math.max(ans, dp[i]);
        return ans;
    }
}
