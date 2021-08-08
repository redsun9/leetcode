package leetcode.leetcode19xx.leetcode1957;

public class Solution {
    public String makeFancyString(String str) {
        int n = str.length();
        if (n <= 2) return str;
        char[] s = str.toCharArray();
        char[] ans = new char[n];
        ans[0] = s[0];
        ans[1] = s[1];
        int ansLength = 2;
        for (int i = 2; i < n; i++) {
            if (s[i] != s[i - 1] || s[i] != s[i - 2]) ans[ansLength++] = s[i];
        }
        return new String(ans, 0, ansLength);
    }
}
