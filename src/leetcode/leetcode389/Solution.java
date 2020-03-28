package leetcode.leetcode389;

public class Solution {
    public char findTheDifference(String s, String t) {
        int[] cs = new int[26];
        for (char c : s.toCharArray()) {
            cs[c - 'a']++;
        }
        int[] ct = new int[26];
        for (char c : t.toCharArray()) {
            ct[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (cs[i] != ct[i]) return (char) ('a' + i);
        }
        return 'a';
    }
}
