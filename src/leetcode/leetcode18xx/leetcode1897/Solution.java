package leetcode.leetcode18xx.leetcode1897;

public class Solution {
    public boolean makeEqual(String[] words) {
        int n = words.length;
        if (n == 1) return true;
        int total = 0;
        for (String word : words) total += word.length();
        if (total % n != 0) return false;
        int[] count = new int[26];
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                count[word.charAt(i) - 'a']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] % n != 0) return false;
        }
        return true;
    }
}
