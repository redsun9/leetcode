package leetcode.leetcode1xx.leetcode186;

public class Solution {
    public char[] reverseWords(char[] str) {
        int n = str.length;
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (str[i] == ' ') {
                reverse(str, start, i - 1);
                start = i + 1;
            }
        }
        if (start != 0) {
            reverse(str, start, n - 1);
            reverse(str, 0, n - 1);
        }
        return str;
    }

    private static void reverse(char[] str, int start, int end) {
        while (start < end) {
            char tmp = str[start];
            str[start] = str[end];
            str[end] = tmp;
            start++;
            end--;
        }
    }
}
