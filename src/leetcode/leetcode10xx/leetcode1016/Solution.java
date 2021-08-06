package leetcode.leetcode10xx.leetcode1016;

public class Solution {
    public boolean queryString(String s, int n) {
        int m = s.length();
        int[] pref = new int[m + 1];
        for (int i = 0; i < m; i++) pref[i + 1] = pref[i] << 1 | (s.charAt(i) - '0');
        for (int i = n; i > n / 2; i--) {
            boolean absent = true;
            int mask = (Integer.highestOneBit(i) << 1) - 1;
            for (int j = 1; absent && j <= m; j++) absent = (pref[j] & mask) != i;
            if (absent) return false;
        }
        return true;
    }
}
