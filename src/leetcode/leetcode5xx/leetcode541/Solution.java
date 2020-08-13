package leetcode.leetcode5xx.leetcode541;

public class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        if (n <= 1 || k == 1) return s;
        char[] chars = s.toCharArray();
        int left = 0;
        int right = k;
        while (right <= n) {
            reverse(chars, left, right);
            left += 2 * k;
            right += 2 * k;
        }
        if (left < n) reverse(chars, left, n);
        return new String(chars);
    }

    // swap [from;to)
    private static void reverse(char[] chars, int from, int to) {
        to--;
        while (from < to) {
            char tmp = chars[from];
            chars[from] = chars[to];
            chars[to] = tmp;
            from++;
            to--;
        }
    }
}
