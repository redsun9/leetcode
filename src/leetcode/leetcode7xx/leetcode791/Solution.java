package leetcode.leetcode7xx.leetcode791;

import java.util.Arrays;

public class Solution {
    public String customSortString(String s, String t) {
        int n = s.length();
        if (n <= 1 || t.length() <= 1) return t;
        char[] chars = t.toCharArray();
        int[] count = new int[26];
        for (char c : chars) count[c - 'a']++;
        boolean[] exists = new boolean[26];
        int pos = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            exists[c - 'a'] = true;
            Arrays.fill(chars, pos, pos + count[c - 'a'], c);
            pos += count[c - 'a'];
        }
        for (int i = 0; i < 26; i++) {
            if (!exists[i]) {
                Arrays.fill(chars, pos, pos + count[i], (char) (i + 'a'));
                pos += count[i];
            }
        }
        return new String(chars);
    }
}
