package leetcode.leetcode25xx.leetcode2559;

public class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            String word = words[i];
            int m = word.length();
            boolean ok = isVowel(word.charAt(0)) && isVowel(word.charAt(m - 1));
            dp[i + 1] = dp[i] + (ok ? 1 : 0);
        }
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int[] query = queries[i];
            int l = query[0];
            int r = query[1];
            ans[i] = dp[r + 1] - dp[l];
        }
        return ans;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
