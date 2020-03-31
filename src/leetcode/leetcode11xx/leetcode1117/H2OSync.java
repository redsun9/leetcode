package leetcode.leetcode11xx.leetcode1117;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class H2OSync implements H2O {
    private Semaphore h, o;
    private AtomicInteger counter = new AtomicInteger(0);

    public H2OSync() {
        h = new Semaphore(2, true);
        o = new Semaphore(1, true);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        h.acquire();
        releaseHydrogen.run();
        if (counter.incrementAndGet() == 3) release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        o.acquire();
        releaseOxygen.run();
        if (counter.incrementAndGet() == 3) release();
    }

    private void release() {
        counter.set(0);
        h.release(2);
        o.release(1);
    }

}
