package leetcode.leetcode23xx.leetcode2309;

public class Solution {
    public String greatestLetter(String s) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') lower[c - 'a'] = true;
            else upper[c - 'A'] = true;
        }
        for (int i = 25; i >= 0; i--) {
            if (lower[i] && upper[i]) return String.valueOf((char) ('A' + i));
        }
        return "";
    }
}
