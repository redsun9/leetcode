package leetcode.leetcode24xx.leetcode2434;

import java.util.Stack;

public class Solution {
    public String robotWithString(String s) {
        int n = s.length();
        if (n <= 1) return s;
        Stack<Integer> right = new Stack<>();
        Stack<Character> left = new Stack<>();
        for (int i = n - 1; i >= 0; i--) if (right.isEmpty() || s.charAt(right.peek()) >= s.charAt(i)) right.push(i);
        char[] ans = new char[n];
        for (int i = 0, j = 0; j < n; ) {
            if (!right.isEmpty()) {
                int poll = right.pop();
                char charRight = s.charAt(poll);
                while (!left.isEmpty() && left.peek() <= charRight) ans[j++] = left.pop();
                while (i < poll) left.push(s.charAt(i++));
                ans[j++] = charRight;
                i++;
            } else {
                while (!left.isEmpty()) ans[j++] = left.pop();
            }
        }
        return new String(ans);
    }
}
