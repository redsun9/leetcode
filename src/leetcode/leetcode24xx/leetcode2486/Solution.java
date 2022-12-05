package leetcode.leetcode24xx.leetcode2486;

public class Solution {
    public int appendCharacters(String s, String t) {
        int m = s.length(), n = t.length();
        int i = 0, j = 0;
        while (i < m && j < n) if (s.charAt(i++) == t.charAt(j)) j++;
        return n - j;
    }
}
