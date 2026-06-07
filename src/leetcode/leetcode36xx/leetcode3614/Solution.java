package leetcode.leetcode36xx.leetcode3614;

public class Solution {
    public char processStr(String s, long k) {
        long totalLength = 0;
        int pos = 0;
        char[] clean = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '*' -> {
                    totalLength = Math.max(totalLength - 1, 0);
                    if (totalLength == 0) pos = 0;
                    else clean[pos++] = '*';
                }
                case '#' -> {
                    totalLength *= 2;
                    if (totalLength != 0) clean[pos++] = '#';
                }
                case '%' -> {
                    if (totalLength != 0) clean[pos++] = '%';
                }
                default -> {
                    totalLength++;
                    clean[pos++] = s.charAt(i);
                }
            }
        }


        if (k >= totalLength) return '.';
        while (true) {
            char c = clean[--pos];
            switch (c) {
                case '*' -> {
                    totalLength++;
                }
                case '#' -> {
                    totalLength /= 2;
                    k %= totalLength;
                }
                case '%' -> {
                    k = totalLength - 1 - k;
                }
                default -> {
                    if (--totalLength == k) return c;
                }
            }
        }
    }
}
