package leetcode.leetcode8xx.leetcode890;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int m = pattern.length();
        if (m == 1) return List.of(words);
        int[] patternMask = new int[m];
        int[] patternCharToNumber = new int[26];
        int patternUsedChars = 0;
        for (int i = 0; i < m; i++) {
            int c = pattern.charAt(i) - 'a';
            if (patternCharToNumber[c] == 0) {
                patternMask[i] = patternUsedChars;
                patternCharToNumber[c] = ++patternUsedChars;
            } else {
                patternMask[i] = patternCharToNumber[c] - 1;
            }
        }

        List<String> ans = new ArrayList<>();
        for (String word : words) {
            boolean ok = true;
            int[] wordMask = new int[m];
            int[] wordCharToNumber = new int[26];
            int wordUsedChars = 0;
            for (int i = 0; i < m; i++) {
                int c = word.charAt(i) - 'a';
                if (wordCharToNumber[c] == 0) {
                    wordMask[i] = wordUsedChars;
                    wordCharToNumber[c] = ++wordUsedChars;
                } else {
                    wordMask[i] = wordCharToNumber[c] - 1;
                }
                if (patternMask[i] != wordMask[i]) {
                    ok = false;
                    break;
                }
            }
            if (ok) ans.add(word);
        }
        return ans;
    }
}
