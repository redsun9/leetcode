package leetcode.leetcode21xx.leetcode2129;

public class Solution {
    private static final int DIFF_BETWEEN_CASES = 'a' - 'A';

    public String capitalizeTitle(String title) {
        char[] s = title.toCharArray();
        int n = s.length;
        for (int l = 0, r = 0; l < n; ) {
            while (r < n && s[r] != ' ') r++;
            if (r - l <= 2) {
                for (int i = l; i < r; i++) if (s[i] < 'a') s[i] += DIFF_BETWEEN_CASES;
            } else {
                if (s[l] >= 'a') s[l] -= DIFF_BETWEEN_CASES;
                for (int i = l + 1; i < r; i++) if (s[i] < 'a') s[i] += DIFF_BETWEEN_CASES;
            }
            r = r + 1;
            l = r;
        }
        return new String(s);
    }
}
