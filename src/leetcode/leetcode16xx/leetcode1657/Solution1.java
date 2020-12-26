package leetcode.leetcode16xx.leetcode1657;

import java.util.Arrays;

public class Solution1 {
    public boolean closeStrings(String word1, String word2) {
        int n = word1.length();
        if (word2.length() != n) return false;
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < n; i++) {
            count1[word1.charAt(i) - 'a']++;
            count2[word2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if ((count1[i] == 0) ^ (count2[i] == 0)) return false;
        }
        Arrays.sort(count1);
        Arrays.sort(count2);
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) return false;
        }
        return true;
    }
}
