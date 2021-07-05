package leetcode.leetcode10xx.leetcode1021;

public class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        char[] ans = new char[n];
        int pos = 0, count = 0;
        for (int i = 0; i < n; i++)
            if (s.charAt(i) == '(') {
                if (count++ != 0) ans[pos++] = '(';
            } else {
                if (--count != 0) ans[pos++] = ')';
            }
        return new String(ans, 0, pos);
    }
}
