package leetcode.leetcode10;

public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        char currentStringChar, currentPatternChar, previousPatternChar = 0;
        boolean previousIsDot = false;
        for (int i = 0; i < s.length(); i++) {
            currentStringChar = s.charAt(i);
            for (int j = 0; j < p.length(); j++) {
                currentPatternChar = p.charAt(j);
                if (currentPatternChar == '.' || currentPatternChar == currentStringChar) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (currentPatternChar == '*') {
                    if (previousPatternChar != currentStringChar && previousIsDot) {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                    }
                }
                previousPatternChar = currentPatternChar;
                previousIsDot = previousPatternChar != '.';
            }
        }
        return dp[s.length()][p.length()];
    }
}
