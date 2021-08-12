package leetcode.leetcode2xx.leetcode225;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings({"ConstantConditions", "unused"})
public class MyStack {
    private final Queue<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.add(x);
        int s = queue.size();
        while (s-- > 1) queue.add(queue.poll());
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue.remove();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue.peek();

    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}
