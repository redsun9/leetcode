package leetcode.leetcode11xx.leetcode1190;

import java.util.Stack;

public class Solution {
    public String reverseParentheses(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();

        Stack<Integer> stack = new Stack<>();
        int[] pairs = new int[n];
        for (int i = 0; i < n; i++) {
            if (chars[i] == '(') stack.push(i);
            else if (chars[i] == ')') {
                int j = stack.pop();
                pairs[i] = j;
                pairs[j] = i;
            }
        }

        char[] ans = new char[n];
        int ansLength = 0;
        for (int i = 0, d = 1; i < n; i += d) {
            char c = chars[i];
            if (c == '(' || c == ')') {
                i = pairs[i];
                d = -d;
            } else {
                ans[ansLength++] = c;
            }
        }
        return new String(ans, 0, ansLength);
    }
}
