package leetcode.leetcode10xx.leetcode1047;

public class Solution {
    public String removeDuplicates(String s) {
        int n = s.length();
        if (n == 1) return s;
        char[] ans = new char[n];
        int ansLength = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (ansLength != 0 && ans[ansLength - 1] == c) ansLength--;
            else ans[ansLength++] = c;
        }
        return new String(ans, 0, ansLength);
    }
}
