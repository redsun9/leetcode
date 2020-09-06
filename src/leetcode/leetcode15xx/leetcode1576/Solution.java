package leetcode.leetcode15xx.leetcode1576;

public class Solution {
    public String modifyString(String s) {
        int n = s.length();
        if (n == 0) return s;
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (chars[i] != '?') continue;
            for (char c = 'a'; c <= 'c'; c++) {
                if ((i == 0 || chars[i - 1] != c) && (i == n - 1 || chars[i + 1] != c)) {
                    chars[i] = c;
                    break;
                }
            }
        }
        return new String(chars);
    }
}
