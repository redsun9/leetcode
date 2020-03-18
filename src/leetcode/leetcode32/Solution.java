package leetcode.leetcode32;

import java.util.Stack;

public class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        if (n < 2) return 0;
        char[] chars = s.toCharArray();
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (chars[i] == ')' && !stack.isEmpty() && chars[stack.peek()] == '(') stack.pop();
            else stack.push(i);
        }
        if (stack.isEmpty()) return n;
        int right = n, left;
        while (!stack.isEmpty()) {
            left = stack.pop();
            max = Math.max(max, right - left - 1);
            right = left;
        }
        max = Math.max(max, right);
        return max;
    }
}
