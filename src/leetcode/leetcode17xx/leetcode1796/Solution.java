package leetcode.leetcode17xx.leetcode1796;

public class Solution {
    public int secondHighest(String s) {
        boolean[] seen = new boolean[10];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - '0';
            if (c >= 0 && c <= 9) seen[c] = true;
        }
        boolean first = false;
        for (int i = 9; i >= 0; i--) {
            if (seen[i]) {
                if (first) return i;
                first = true;
            }
        }
        return -1;
    }
}
