package leetcode.leetcode19xx.leetcode1961;

public class Solution {
    public boolean isPrefixString(String s, String[] words) {
        int n = s.length();
        int i = 0, j = 0, m = words.length;
        while (i < n && j < m) {
            String word = words[j];
            int length = word.length();
            int k = 0;
            while (i < n && k < length && s.charAt(i) == word.charAt(k)) {
                i++;
                k++;
            }
            if (k == length && i == n) return true;
            if (i == n || k != length) return false;
            j++;
        }
        return false;
    }
}
