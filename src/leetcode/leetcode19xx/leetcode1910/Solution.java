package leetcode.leetcode19xx.leetcode1910;

public class Solution {
    private static String removeChar(String s, char c) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            if (c1 != c) sb.append(c1);
        }
        return sb.toString();
    }

    private static int[] kmp(String s) {
        int n = s.length();
        int[] ans = new int[n];
        for (int i = 1, j = 0; i < n; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) j = ans[j - 1];
            if (s.charAt(i) == s.charAt(j)) j++;
            ans[i] = j;
        }
        return ans;
    }

    public String removeOccurrences(String s, String part) {
        int m = part.length();
        if (m == 1) return removeChar(s, part.charAt(0));
        int n = s.length();
        int[] kmp = kmp(part);
        char[] ans = new char[n];
        int[] idx = new int[n + 1];
        int ansLength = 0;
        for (int i = 0, j = 0; i < n; i++) {
            char c = s.charAt(i);
            ans[ansLength++] = c;
            if (c == part.charAt(j)) {
                idx[ansLength] = ++j;
                if (j == m) {
                    ansLength = ansLength - m;
                    j = ansLength == 0 ? 0 : idx[ansLength];
                }
            } else {
                if (j != 0) {
                    i--;
                    j = kmp[j - 1];
                    ansLength--;
                }
            }
        }
        return new String(ans, 0, ansLength);
    }
}
