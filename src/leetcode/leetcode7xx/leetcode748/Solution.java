package leetcode.leetcode7xx.leetcode748;

public class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] counts = new int[26];
        int totalCount = 0;
        int totalDifferent = 0;
        for (int i = 0; i < licensePlate.length(); i++) {
            char c = licensePlate.charAt(i);
            if (Character.isLetter(c)) {
                int a = Character.toLowerCase(c) - 'a';
                if (counts[a]++ == 0) totalDifferent++;
                totalCount++;
            }
        }
        String ans = null;
        for (String word : words) {
            if (word.length() < totalCount || ans != null && ans.length() <= word.length()) continue;
            int[] wordCount = new int[26];
            int wordTotalDifferent = 0;
            for (int i = 0; i < word.length(); i++) {
                int c = word.charAt(i) - 'a';
                if (counts[c] == ++wordCount[c]) wordTotalDifferent++;
            }
            if (totalDifferent == wordTotalDifferent) ans = word;
        }
        return ans;
    }
}
