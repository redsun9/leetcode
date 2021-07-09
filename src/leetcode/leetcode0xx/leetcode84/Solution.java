package leetcode.leetcode0xx.leetcode84;

import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                Integer pop = stack.pop();
                ans = Math.max(ans, (i - (stack.isEmpty() ? 0 : stack.peek() + 1)) * heights[pop]);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            ans = Math.max(ans, (n - (stack.isEmpty() ? 0 : stack.peek() + 1)) * heights[pop]);
        }
        return ans;
    }
}
