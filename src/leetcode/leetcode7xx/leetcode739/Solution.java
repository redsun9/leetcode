package leetcode.leetcode7xx.leetcode739;

import java.util.Stack;

public class Solution {
    public int[] dailyTemperatures(int[] t) {
        int n = t.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && t[stack.peek()] <= t[i]) stack.pop();
            if (!stack.isEmpty()) ans[i] = stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }
}
