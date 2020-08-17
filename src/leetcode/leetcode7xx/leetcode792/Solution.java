package leetcode.leetcode7xx.leetcode792;

import java.util.Arrays;

public class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int n = s.length();
        int[][] dp = new int[n + 1][26];
        Arrays.fill(dp[n], -100);
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Arrays.copyOf(dp[i + 1], 26);
            dp[i][s.charAt(i) - 'a'] = i;
        }
        int ans = 0;
        for (String word : words) {
            int m = word.length();
            int i = 0, j = 0;
            while (j >= 0 && i < m) {
                j = dp[j][word.charAt(i++) - 'a'] + 1;
            }
            if (j >= 0) ans++;
        }
        return ans;
    }
}
