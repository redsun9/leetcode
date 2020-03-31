package leetcode.leetcode11xx.leetcode1172;

import java.util.HashMap;
import java.util.Stack;

public class DinnerPlates {
    private final CustomStack leftBorder;
    private final CustomStack rightBorder;
    private final int maxSizeOfStack;
    private final HashMap<Integer, CustomStack> map;
    private CustomStack leftMost;

    public DinnerPlates(int capacity) {
        map = new HashMap<>();
        maxSizeOfStack = capacity;
        leftBorder = new CustomStack();
        leftBorder.index = 0;
        rightBorder = new CustomStack();
        rightBorder.index = Integer.MAX_VALUE;
        rightBorder.left = leftBorder;
        leftBorder.right = rightBorder;
        leftMost = leftBorder;
        map.put(0, leftBorder);
        map.put(rightBorder.index, rightBorder);
    }

    public void push(int val) {
        if (leftMost.stack.size() < maxSizeOfStack) {
            leftMost.stack.push(val);
        } else {
            while (leftMost.right.index == leftMost.index + 1 && leftMost.right.stack.size() >= maxSizeOfStack) {
                leftMost = leftMost.right;
            }
            if (leftMost.right.index != leftMost.index + 1) {
                CustomStack customStack = new CustomStack();
                customStack.stack.push(val);
                customStack.index = leftMost.index + 1;
                customStack.left = leftMost;
                customStack.right = leftMost.right;
                leftMost.right.left = customStack;
                leftMost.right = customStack;
                map.put(customStack.index, customStack);
                leftMost = customStack;
            } else {
                leftMost = leftMost.right;
                leftMost.stack.push(val);
            }
        }
    }

    public int pop() {
        if (rightBorder.stack.isEmpty()) {
            CustomStack tmp = rightBorder.left;
            if (tmp.stack.isEmpty()) return -1;
            int ans = tmp.stack.pop();
            if (tmp.stack.isEmpty() && tmp.index != 0) {
                map.remove(tmp.index);
                rightBorder.left = tmp.left;
                tmp.left.right = rightBorder;
                if (tmp == leftMost) {
                    leftMost = leftMost.left;
                }
            }
            return ans;
        } else {
            int ans = rightBorder.stack.pop();
            if (rightBorder.stack.isEmpty() && rightBorder == leftMost) {
                leftMost = leftMost.left;
            }
            return ans;
        }
    }

    public int popAtStack(int index) {
        CustomStack customStack = map.get(index);
        if (customStack == null || customStack.stack.isEmpty()) return -1;
        int ans = customStack.stack.pop();
        if (customStack.index == 0) leftMost = customStack;
        else {
            if (customStack.stack.isEmpty()) {
                customStack.left.right = customStack.right;
                customStack.right.left = customStack.left;
                map.remove(customStack.index);
            }
            if (customStack.index <= leftMost.index) {
                if (customStack.stack.isEmpty()) leftMost = customStack.left;
                else leftMost = customStack;
            }
        }
        return ans;
    }


    private static class CustomStack {
        int index;
        Stack<Integer> stack = new Stack<>();
        CustomStack left;
        CustomStack right;

        @Override
        public String toString() {
            return "[" + index + ":{" + stack + "}] -> " + right;
        }
    }
}
