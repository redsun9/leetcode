package leetcode.leetcode6xx.leetcode678;

import java.util.Stack;

public class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> opened = new Stack<>();
        Stack<Integer> stars = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') opened.push(i);
            else if (c == ')') {
                if (!opened.isEmpty()) {
                    opened.pop();
                } else if (!stars.isEmpty()) {
                    stars.pop();
                } else return false;
            } else stars.push(i);
        }
        while (!opened.isEmpty()) {
            int open = opened.pop();
            if (stars.isEmpty() || stars.pop() < open) return false;
        }
        return true;
    }
}
