package leetcode.leetcode8xx.leetcode856;

import java.util.Stack;

public class Solution2 {
    public int scoreOfParentheses(String s) {
        int n = s.length();
        int cur = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(cur);
                cur = 0;
            } else {
                cur = stack.pop() + Math.max(cur * 2, 1);
            }
        }
        return cur;
    }
}
