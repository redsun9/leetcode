package leetcode.leetcode1381;

public class CustomStack {
    private int[] additions;
    private int[] stack;
    private int capacity;
    private int size;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        additions = new int[maxSize];
        capacity = maxSize;
        size = 0;
    }

    public void push(int x) {
        if (size != capacity) {
            size++;
            stack[size - 1] = x;
            additions[size - 1] = 0;
        }
    }

    public int pop() {
        if (size == 0) return -1;
        size--;
        if (size != 0) {
            additions[size - 1] += additions[size];
            return additions[size] + stack[size];
        } else {
            return additions[0] + stack[0];
        }
    }

    public void increment(int k, int val) {
        if (size != 0) {
            additions[Math.min(k, size) - 1] += val;
        }
    }
}
