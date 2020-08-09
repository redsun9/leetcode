package leetcode.leetcode15xx.leetcode1540;

public class Solution {
    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) return false;
        int n = s.length();
        int[] shifts = new int[26];
        for (int i = 0; i < 26; i++) {
            if (i <= k) shifts[i] = 1 + (k - i) / 26;
        }
        for (int i = 0; i < n; i++) {
            int diff = (t.charAt(i) - s.charAt(i) + 26) % 26;
            if (diff != 0 && --shifts[diff] < 0) return false;
        }
        return true;
    }
}
