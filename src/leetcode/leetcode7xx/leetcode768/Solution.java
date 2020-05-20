package leetcode.leetcode7xx.leetcode768;

import java.util.Stack;

public class Solution {
    public int maxChunksToSorted(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        for (int a : arr) {
            while (!stack.isEmpty() && stack.peek() > a) stack.pop();
            max = Math.max(max, a);
            stack.push(max);
        }
        return stack.size();
    }
}
