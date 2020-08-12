package leetcode.leetcode4xx.leetcode409;

public class Solution {
    public int longestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) return n;
        int[] countLower = new int[26];
        int[] countUpper = new int[26];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c < 'a') countUpper[c - 'A']++;
            else countLower[c - 'a']++;
        }
        boolean oddExist = false;
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans += countLower[i] / 2 * 2 + countUpper[i] / 2 * 2;
            oddExist |= (countLower[i] & 1) == 1 | (countUpper[i] & 1) == 1;
        }
        if (oddExist) ans++;
        return ans;
    }
}
