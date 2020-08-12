package leetcode.leetcode2xx.leetcode290;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> charToWord = new HashMap<>();
        HashSet<String> alreadyUsedWords = new HashSet<>();
        int wordStart = 0;
        int strLength = str.length();
        int patternLength = pattern.length();
        for (int i = 0; i < patternLength; i++) {
            if (wordStart >= strLength) return false;
            char c = pattern.charAt(i);
            int wordEnd = wordStart + 1;
            while (wordEnd < strLength && str.charAt(wordEnd) != ' ') wordEnd++;
            String s = str.substring(wordStart, wordEnd);
            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(s)) return false;
            } else {
                if (alreadyUsedWords.contains(s)) return false;
                charToWord.put(c, s);
                alreadyUsedWords.add(s);
            }
            wordStart = wordEnd + 1;
        }
        return wordStart >= strLength;
    }
}
