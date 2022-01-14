package leetcode.leetcode0xx.leetcode8;

public class Solution {
    private static final long maxForPositive = Integer.MAX_VALUE;
    private static final long maxForNegative = Integer.MAX_VALUE + 1L;

    public int myAtoi(String s) {
        boolean positive = true;
        long val = 0;
        int i = 0, n = s.length();

        while (i < n && s.charAt(i) == ' ') i++;
        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            positive = s.charAt(i++) == '+';
        }

        while (i < n) {
            char c = s.charAt(i++);
            if (c < '0' || c > '9') break;
            val = val * 10 + c - '0';
            if (positive && val >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
            else if (!positive && val >= maxForNegative) return Integer.MIN_VALUE;
        }
        if (positive) return (int) val;
        else return (int) -val;
    }
}
