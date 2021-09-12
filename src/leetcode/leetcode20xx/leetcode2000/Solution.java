package leetcode.leetcode20xx.leetcode2000;

public class Solution {
    public String reversePrefix(String word, char ch) {
        int pos = word.indexOf(ch);
        if (pos <= 0) return word;
        return new StringBuilder(word.substring(0, pos + 1)).reverse() + word.substring(pos + 1);
    }
}
