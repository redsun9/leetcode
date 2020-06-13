package leetcode.leetcode6xx.leetcode680;

public class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length();
        if (n <= 2) return true;
        int start = 0, end = n - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return isPalindromic(s, start, end - 1) || isPalindromic(s, start + 1, end);
            }
            start++;
            end--;
        }
        return true;
    }

    public boolean isPalindromic(String s, int start, int end) {
        while (start < end)
            if (s.charAt(start++) != s.charAt(end--)) return false;
        return true;
    }
}
