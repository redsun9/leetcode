package leetcode.leetcode1xx.leetcode155;

import java.util.Stack;

public class MinStack {
    private final Stack<Integer> stack;
    private final Stack<Integer> minimums;

    public MinStack() {
        stack = new Stack<>();
        minimums = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minimums.isEmpty() || minimums.peek() >= x) minimums.push(x);
    }

    public void pop() {
        if (minimums.peek().equals(stack.pop())) minimums.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minimums.peek();
    }
}
