package leetcode.leetcode18xx.leetcode1816;

public class Solution {
    public String truncateSentence(String s, int k) {
        int i = -1;
        int n = s.length();
        while (++i < n && k != 0) {
            if (s.charAt(i) == ' ') k--;
        }
        return i != n ? s.substring(0, i - 1) : s;
    }
}
