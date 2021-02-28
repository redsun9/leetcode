package leetcode.leetcode17xx.leetcode1763;

public class Solution {
    private static String longestNiceSubstring(String s, int start, int end) {
        if (start >= end) return "";
        boolean[][] cnt = new boolean[2][26];
        for (int i = start; i < end; i++) {
            char c = s.charAt(i);
            cnt[Character.isLowerCase(c) ? 0 : 1][Character.toLowerCase(c) - 'a'] = true;
        }
        String ans = "";
        int pos = start;
        for (int i = start; i < end; i++) {
            int c = Character.toLowerCase(s.charAt(i)) - 'a';
            if (cnt[0][c] != cnt[1][c]) {
                String tmp = longestNiceSubstring(s, pos, i);
                if (tmp.length() > ans.length()) ans = tmp;
                pos = i + 1;
            }
        }
        if (pos < end) {
            if (pos == start) return s.substring(start, end);
            else {
                String tmp = longestNiceSubstring(s, pos, end);
                if (tmp.length() > ans.length()) ans = tmp;
            }
        }
        return ans;
    }

    public String longestNiceSubstring(String s) {
        return longestNiceSubstring(s, 0, s.length());
    }
}
