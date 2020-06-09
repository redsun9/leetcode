package leetcode.leetcode9xx.leetcode946;

import java.util.Stack;

public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        if (n == 0) return true;
        if (n == 1) return pushed[0] == popped[0];
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        while (i < n && j < n) {
            while (i < n && (stack.isEmpty() || stack.peek() != popped[j])) stack.push(pushed[i++]);
            while (j < n && !stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return i == n && j == n;
    }
}
