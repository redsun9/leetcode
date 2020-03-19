package leetcode.leetcode1115;

import java.util.concurrent.Semaphore;

public class FooBar {
    private int n;
    private Semaphore f, b;

    public FooBar(int n) {
        this.n = n;
        f = new Semaphore(1);
        b = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            f.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            b.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            b.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            f.release();
        }
    }
}
