package leetcode.leetcode13xx.leetcode1328;

public class Solution {
    public String breakPalindrome(String s) {
        int n = s.length();
        int k = n / 2;
        if (n == 1) return "";
        for (int i = 0; i < k; i++) {
            if (s.charAt(i) != 'a') return s.substring(0, i) + 'a' + s.substring(i + 1);
        }
        return s.substring(0, n - 1) + 'b';
    }
}
