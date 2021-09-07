package leetcode.leetcode0xx.leetcode76;

public class Solution2 {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if (n == 0 || m < n) return "";

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (int i = 0; i < n; i++) {
            char c = t.charAt(i);
            if (c >= 'a' && c <= 'z') count1[c - 'a']++;
            else count2[c - 'A']++;
        }

        int diff = 0;
        for (int c : count1) if (c != 0) diff++;
        for (int c : count2) if (c != 0) diff++;

        int ansStart = -1, ansEnd = m;
        for (int l = 0, r = 0; r < m; ) {
            char c = s.charAt(r++);
            if (c >= 'a' && c <= 'z') {
                if (--count1[c - 'a'] == 0) diff--;
            } else {
                if (--count2[c - 'A'] == 0) diff--;
            }

            while (diff == 0) {
                c = s.charAt(l++);
                if (c >= 'a' && c <= 'z') {
                    if (count1[c - 'a']++ == 0) diff++;
                } else {
                    if (count2[c - 'A']++ == 0) diff++;
                }
                if (r - l + 1 < ansEnd - ansStart) {
                    ansStart = l - 1;
                    ansEnd = r;
                }
            }
        }

        return ansStart == -1 ? "" : s.substring(ansStart, ansEnd);
    }
}
