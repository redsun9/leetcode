package leetcode.leetcode1xx.leetcode161;

public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length(), n = t.length();
        return
                (m == n && isOneReplace(s, t)) ||
                        (m == n + 1 && isOneDelete(s, t)) ||
                        (m + 1 == n && isOneDelete(t, s));
    }

    private static boolean isOneReplace(String s, String t) {
        int n = s.length();
        boolean oneReplace = false;
        int i = 0;
        while (i < n) {
            if (s.charAt(i) != t.charAt(i)) {
                if (oneReplace) return false;
                oneReplace = true;
            }
            i++;
        }
        return oneReplace;
    }

    // s.length() = t.length()+1
    private static boolean isOneDelete(String s, String t) {
        int n = t.length();
        boolean oneDelete = false;
        int i = 0, j = 0;
        while (j < n) {
            if (s.charAt(i) != t.charAt(j)) {
                if (oneDelete) return false;
                oneDelete = true;
            } else j++;
            i++;
        }
        return oneDelete || i == n;
    }
}
