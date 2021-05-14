package leetcode.leetcode16xx.leetcode1689;

public class Solution {
    public int minPartitions(String s) {
        int c = '0';
        for (int i = s.length() - 1; i >= 0; i--) c = Math.max(c, s.charAt(i));
        return c - '0';
    }
}
