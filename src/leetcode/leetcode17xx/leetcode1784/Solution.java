package leetcode.leetcode17xx.leetcode1784;

public class Solution {
    public boolean checkOnesSegment(String s) {
        boolean meetZero = false;
        int n = s.length();
        int pos = 0;
        while (pos < n && s.charAt(pos) == '1') pos++;
        pos++;
        while (pos < n && s.charAt(pos) == '0') pos++;
        return pos >= n;
    }
}
