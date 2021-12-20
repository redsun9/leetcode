package leetcode.leetcode21xx.leetcode2109;

public class Solution {
    public String addSpaces(String str, int[] spaces) {
        int n = spaces.length;
        if (n == 0) return str;
        int m = str.length();
        char[] s = str.toCharArray();
        char[] ans = new char[m + n];

        for (int i = 0, j1 = 0, j2 = 0; j1 < m || j2 < n; i++) {
            if (j2 < n && i == j2 + spaces[j2]) {
                ans[i] = ' ';
                j2++;
            } else ans[i] = s[j1++];
        }
        return new String(ans);
    }
}
