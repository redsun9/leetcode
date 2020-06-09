package leetcode.leetcode3xx.leetcode392;

public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;
        if (t.isEmpty()) return false;
        int m = s.length();
        int n = t.length();
        if (m > n) return false;
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) i++;
            j++;
        }
        return i == m;
    }
}
