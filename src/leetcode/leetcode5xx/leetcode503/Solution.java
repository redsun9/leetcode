package leetcode.leetcode5xx.leetcode503;

import java.util.Stack;

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int j = 0; j < 2; j++) {
            for (int i = n - 1; i >= 0; i--) {
                while (!stack.isEmpty() && stack.peek() <= nums[i]) stack.pop();
                if (stack.isEmpty()) ans[i] = -1;
                else ans[i] = stack.peek();
                stack.push(nums[i]);
            }
        }
        return ans;
    }
}
