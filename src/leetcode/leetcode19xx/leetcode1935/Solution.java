package leetcode.leetcode19xx.leetcode1935;

public class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int n = text.length();
        if (n == 0) return 0;

        int m = brokenLetters.length();
        boolean[] broken = new boolean[26];
        for (int i = 0; i < m; i++) broken[brokenLetters.charAt(i) - 'a'] = true;

        int ans = 0;
        boolean failed = false;
        for (int i = 0; i < n; i++) {
            char c = text.charAt(i);
            if (c >= 'a' && c <= 'z') failed |= broken[c - 'a'];
            if (c == ' ' || i == n - 1) {
                if (!failed) ans++;
                failed = false;
            }
        }
        return ans;

    }
}