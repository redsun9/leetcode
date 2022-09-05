package leetcode.leetcode23xx.leetcode2399;

public class Solution {
    public boolean checkDistances(String s, int[] distance) {
        int n = s.length();
        int[] prev = new int[26];
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (prev[c] == 0) prev[c] = i + 1;
            else if (i - prev[c] != distance[c]) return false;
        }
        return true;
    }
}
