package leetcode.leetcode18xx.leetcode1849;

public class Solution {
    private static boolean splitString(String s, int pos, int n, Long previous) {
        long curr = 0;
        for (int i = pos; i < n; i++) {
            curr = curr * 10 + s.charAt(i) - '0';
            if (curr >= 1e10) return false;
            if (previous == null) {
                if (splitString(s, i + 1, n, curr))
                    return true;
            } else if (curr == previous - 1 && (i == n - 1 || splitString(s, i + 1, n, curr)))
                return true;
        }
        return false;
    }

    public boolean splitString(String s) {
        return splitString(s, 0, s.length(), null);
    }
}
