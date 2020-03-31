package leetcode.leetcode11xx.leetcode1117;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class H2OAsync implements H2O {
    private BlockingQueue<Runnable> hq = new LinkedBlockingQueue<>();
    private BlockingQueue<Runnable> oq = new LinkedBlockingQueue<>();

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hq.offer(releaseHydrogen);
        release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oq.offer(releaseOxygen);
        release();
    }

    private void release() {
        if (hq.size() >= 2 && oq.size() >= 1) {
            synchronized (this) {
                if (hq.size() >= 2 && oq.size() >= 1) {
                    hq.poll().run();
                    oq.poll().run();
                    hq.poll().run();
                }
            }
        }
    }
}
