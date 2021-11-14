package leetcode.leetcode20xx.leetcode2068;

public class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int n = word1.length();
        if (n <= 3) return true;

        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[word1.charAt(i) - 'a']++;
            count[word2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] > 3 || count[i] < -3) return false;
        }
        return true;
    }
}
