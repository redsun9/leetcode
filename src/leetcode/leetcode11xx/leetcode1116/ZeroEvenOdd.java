package leetcode.leetcode11xx.leetcode1116;

import java.util.function.IntConsumer;

public abstract class ZeroEvenOdd {
    ZeroEvenOdd(int n) {
    }

    ;

    public abstract ZeroEvenOdd getInstance(int n);

    // printNumber.accept(x) outputs "x", where x is an integer.
    public abstract void zero(IntConsumer printNumber) throws InterruptedException;

    public abstract void even(IntConsumer printNumber) throws InterruptedException;

    public abstract void odd(IntConsumer printNumber) throws InterruptedException;
}
