package leetcode.leetcode18xx.leetcode1881;

public class Solution {
    public String maxValue(String s, int x) {
        boolean isPositive = s.charAt(0) != '-';
        int n = s.length();
        int pos = isPositive ? 0 : 1;
        while (pos < n) {
            int c = s.charAt(pos) - '0';
            if (
                    (isPositive && (c < x)) ||
                            (!isPositive && (c > x))
            ) break;
            pos++;
        }
        return s.substring(0, pos) + x + s.substring(pos);
    }
}
