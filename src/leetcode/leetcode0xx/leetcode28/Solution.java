package leetcode.leetcode0xx.leetcode28;

public class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if (n == 0) return 0;
        if (m < n) return -1;
        if (m == n) return haystack.equals(needle) ? 0 : -1;
        int[] kmp = kmp(needle);
        for (int i = 0, j = 0; i < m; ) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            if (j == n) return i - j;
            if (i < m && haystack.charAt(i) != needle.charAt(j)) {
                if (j != 0) {
                    j = kmp[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }

    private static int[] kmp(String needle) {
        int n = needle.length();
        int[] ans = new int[n];
        for (int i = 1, len = 0; i < n; ) {
            if (needle.charAt(i) == needle.charAt(len)) {
                ans[i++] = ++len;
            } else if (len != 0) {
                len = ans[len - 1];
            } else {
                ans[i++] = 0;
            }
        }
        return ans;
    }
}
