package leetcode.leetcode3xx.leetcode346;

import java.util.ArrayDeque;
import java.util.Deque;

@SuppressWarnings("ConstantConditions")
public class MovingAverage {
    private final Deque<Integer> deque;
    private final int maxSize;
    private long sum = 0;

    public MovingAverage(int size) {
        this.deque = new ArrayDeque<>(size);
        this.maxSize = size;
    }

    public double next(int val) {
        sum += val;
        if (deque.size() == maxSize) sum -= deque.poll();
        deque.add(val);
        return (double) sum / deque.size();
    }
}
