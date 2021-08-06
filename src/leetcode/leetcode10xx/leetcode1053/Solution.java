package leetcode.leetcode10xx.leetcode1053;

import java.util.Stack;

public class Solution {
    public int[] prevPermOpt1(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr.length - 1);
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                int j = stack.pop();
                while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) j = stack.pop();
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                break;
            } else {
                if (arr[i] == arr[stack.peek()]) stack.pop();
                stack.push(i);
            }
        }
        return arr;
    }
}
