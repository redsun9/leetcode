package leetcode.leetcode21xx.leetcode2108;

public class Solution {
    public String firstPalindrome(String[] words) {
        for (String word : words) {
            boolean ok = true;
            for (int i = 0, j = word.length() - 1; ok && i < j; i++, j--) {
                ok = word.charAt(i) == word.charAt(j);
            }
            if (ok) return word;
        }
        return "";
    }
}
