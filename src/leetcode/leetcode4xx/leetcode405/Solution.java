package leetcode.leetcode4xx.leetcode405;

public class Solution {
    public String toHex(int num) {
        StringBuilder sb = new StringBuilder();
        do {
            int c = num & 0xf;
            if (c < 10) sb.insert(0, c);
            else sb.insert(0, (char) ('a' + c - 10));
            num >>>= 4;
        } while (num != 0);
        return sb.toString();
    }
}
