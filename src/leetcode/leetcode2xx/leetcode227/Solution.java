package leetcode.leetcode2xx.leetcode227;

import java.util.Stack;

public class Solution {
    public int calculate(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') num = num * 10 + c - '0';
            if (i == n - 1 || (c != ' ' && (c < '0' || c > '9'))) {
                switch (sign) {
                    case '-' -> stack.push(-num);
                    case '+' -> stack.push(num);
                    case '*' -> stack.push(stack.pop() * num);
                    case '/' -> stack.push(stack.pop() / num);
                }
                sign = c;
                num = 0;
            }
        }

        int ans = 0;
        for (int a : stack) ans += a;
        return ans;
    }

}
