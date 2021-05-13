package leetcode.leetcode6xx.leetcode622;

public class MyCircularQueue {
    private final int[] a;
    private final int n;
    private int start, end, size;

    public MyCircularQueue(int n) {
        this.a = new int[n];
        this.n = n;
        this.start = 0;
        this.end = n - 1;
        this.size = 0;
    }

    public boolean enQueue(int value) {
        if (size == n) return false;
        end = (end + 1) % n;
        a[end] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (size == 0) return false;
        start = (start + 1) % n;
        size--;
        return true;
    }

    public int Front() {
        if (size == 0) return -1;
        return a[start];
    }

    public int Rear() {
        if (size == 0) return -1;
        return a[end];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == n;
    }
}
