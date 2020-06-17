package leetcode.leetcode7xx.leetcode767;

public class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        if (n < 2) return s;
        int[] count = new int[26];
        for (int i = 0; i < n; i++) count[s.charAt(i) - 'a']++;
        int maxCount = 0;
        int maxChar = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                maxChar = i;
            }
        }
        if (maxCount > n - maxCount + 1) return "";
        char[] chars = new char[n];
        int idx = 0;
        for (int i = count[maxChar]; i > 0; i--, idx += 2) {
            chars[idx] = (char) (maxChar + 'a');
        }
        count[maxChar] = 0;

        for (int i = 0; i < 26; i++) {
            for (int j = count[i]; j > 0; j--, idx += 2) {
                if (idx >= n) idx = 1;
                chars[idx] = (char) (i + 'a');
            }
        }
        return new String(chars);
    }
}
