package leetcode.leetcode3xx.leetcode385;

import java.util.Stack;

public class Solution {
    public NestedInteger deserialize(String s) {
        if (s == null || s.isEmpty()) return null;
        if (s.charAt(0) != '[') return new NestedInteger(Integer.parseInt(s));

        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger ans = new NestedInteger();
        stack.push(ans);

        int n = s.length();
        for (int left = 1, right = 1; right < n; right++) {
            char c = s.charAt(right);
            if (c == '[') {
                NestedInteger nestedInteger = new NestedInteger();
                stack.peek().add(nestedInteger);
                stack.push(nestedInteger);
                left = right + 1;
            } else if (c == ',' || c == ']') {
                if (left != right) stack.peek().add(new NestedInteger(Integer.parseInt(s.substring(left, right))));
                left = right + 1;
                if (c == ']') stack.pop();
            }
        }
        return ans;
    }
}
