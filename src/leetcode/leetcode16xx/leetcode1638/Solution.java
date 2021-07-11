package leetcode.leetcode16xx.leetcode1638;

public class Solution {
    private static int helper(String s, String t, int i, int j, int m, int n) {
        int ans = 0;
        int prev = 0, curr = 0;
        while (i < m && j < n) {
            curr++;
            if (s.charAt(i++) != t.charAt(j++)) {
                prev = curr;
                curr = 0;
            }
            ans += prev;
        }
        return ans;
    }

    public int countSubstrings(String s, String t) {
        int m = s.length(), n = t.length();
        int ans = 0;
        for (int i = 0; i < m; i++) ans += helper(s, t, i, 0, m, n);
        for (int i = 1; i < n; i++) ans += helper(s, t, 0, i, m, n);
        return ans;
    }
}
