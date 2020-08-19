package leetcode.leetcode4xx.leetcode456;

import java.util.Stack;

public class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int ak = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < ak) return true;
            //если nums[i] больше текущего второго числа, то апдейтим третье число.
            while (!stack.isEmpty() && nums[i] > stack.peek()) ak = stack.pop();
            stack.push(nums[i]);
        }
        return false;
    }
}
