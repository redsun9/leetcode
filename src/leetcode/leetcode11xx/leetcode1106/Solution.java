package leetcode.leetcode11xx.leetcode1106;

import java.util.ArrayDeque;
import java.util.Deque;

@SuppressWarnings("ConstantConditions")
public class Solution {
    public boolean parseBoolExpr(String expression) {
        int n = expression.length();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char c = expression.charAt(i);
            if (c == ')') {
                boolean hasTrue = false, hasFalse = false;
                while (stack.peek().equals('t') || stack.peek().equals('f')) {
                    boolean val = stack.poll() == 't';
                    hasTrue |= val;
                    hasFalse |= !val;
                }
                boolean res = switch (stack.poll()) {
                    case '!' -> hasFalse;
                    case '&' -> !hasFalse;
                    default -> hasTrue;
                };
                stack.push(res ? 't' : 'f');
            } else if (c != ',' && c != '(') stack.push(c);
        }
        return stack.poll() == 't';
    }
}
