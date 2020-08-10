package leetcode.leetcode15xx.leetcode1544;

import java.util.Stack;

public class Solution {
    public static final int diff = Math.abs('A' - 'a');

    public String makeGood(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && Math.abs(stack.peek() - c) == diff) stack.pop();
            else stack.push(c);
        }
        int size = stack.size();
        char[] ans = new char[size];
        while (size > 0) ans[--size] = stack.pop();
        return new String(ans);
    }
}
