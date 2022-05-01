package leetcode.leetcode22xx.leetcode2259;

public class Solution {
    public String removeDigit(String s, char digit) {
        int n = s.length();
        int pos = -1;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == digit) {
                if (i != n - 1 && s.charAt(i + 1) > c) {
                    return s.substring(0, i) + s.substring(i + 1);
                }
                pos = i;
            }
        }
        return s.substring(0, pos) + s.substring(pos + 1);
    }
}
