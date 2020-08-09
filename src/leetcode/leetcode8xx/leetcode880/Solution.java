package leetcode.leetcode8xx.leetcode880;

public class Solution {
    public String decodeAtIndex(String s, long k) {
        long n = 0;
        int i = 0;
        while (n < k) {
            char c = s.charAt(i++);
            n = Character.isDigit(c) ? n * (c - '0') : n + 1;
        }
        while (true) {
            char c = s.charAt(--i);
            if (Character.isDigit(c)) {
                n /= c - '0';
                k %= n;
            } else if (k % n-- == 0) return Character.toString(c);
        }
    }
}
