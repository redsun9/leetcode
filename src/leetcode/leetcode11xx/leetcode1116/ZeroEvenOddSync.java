package leetcode.leetcode11xx.leetcode1116;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class ZeroEvenOddSync extends ZeroEvenOdd {
    private final int n;
    Semaphore semaphoreEven, semaphoreOdd, semaphoreZero;

    public ZeroEvenOddSync(int n) {
        super(n);
        this.n = n;
        semaphoreZero = new Semaphore(1);
        semaphoreEven = new Semaphore(0);
        semaphoreOdd = new Semaphore(0);
    }

    @Override
    public ZeroEvenOdd getInstance(int n) {
        return new ZeroEvenOddSync(n);
    }

    @Override
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            semaphoreZero.acquire();
            printNumber.accept(0);
            if ((i & 1) == 0) {
                semaphoreEven.release();
            } else {
                semaphoreOdd.release();
            }
        }
    }

    @Override
    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            semaphoreEven.acquire();
            printNumber.accept(i);
            semaphoreZero.release();
        }
    }

    @Override
    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            semaphoreOdd.acquire();
            printNumber.accept(i);
            semaphoreZero.release();
        }
    }
}
