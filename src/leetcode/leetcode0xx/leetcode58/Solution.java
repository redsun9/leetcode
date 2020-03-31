package leetcode.leetcode0xx.leetcode58;

public class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if (s.indexOf(' ') < 0) return s.length();
        return s.length() - s.lastIndexOf(' ') - 1;
    }
}
