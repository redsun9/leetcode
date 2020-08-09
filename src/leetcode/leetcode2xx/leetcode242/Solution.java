package leetcode.leetcode2xx.leetcode242;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] counts = new int[26];
        for (int i = s.length() - 1; i >= 0; i--) counts[s.charAt(i) - 'a']++;
        for (int i = t.length() - 1; i >= 0; i--) {
            if (--counts[t.charAt(i) - 'a'] < 0) return false;
        }
        return true;
    }
}
