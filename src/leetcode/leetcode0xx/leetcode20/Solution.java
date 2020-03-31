package leetcode.leetcode0xx.leetcode20;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || !stack.pop().equals('(')) return false;
                    break;
                case ']':
                    if (stack.isEmpty() || !stack.pop().equals('[')) return false;
                    break;
                case '}':
                    if (stack.isEmpty() || !stack.pop().equals('{')) return false;
                    break;
                default:
                    break;
            }
        }
        return stack.isEmpty();
    }
}
