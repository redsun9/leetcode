package leetcode.leetcode13xx.leetcode1309;

public class Solution {
    public static final int diff = 'a' - '1';

    public String freqAlphabets(String s) {
        int n = s.length();
        char[] ans = new char[n];
        int ansStart = n;
        for (int i = n - 1; i >= 0; ) {
            if (s.charAt(i) != '#') {
                ans[--ansStart] = (char) (s.charAt(i) + diff);
                i--;
            } else {
                ans[--ansStart] = (char) ((s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) + diff);
                i -= 3;
            }
        }
        return new String(ans, ansStart, n - ansStart);
    }
}
