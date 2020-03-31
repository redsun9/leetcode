package leetcode.leetcode11xx.leetcode1195;

import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class FizzBuzz {
    private int n;
    private Semaphore f, b, fb, jn;
    private Semaphore[] semaphores;

    public FizzBuzz(int n) {
        this.n = n;
        f = new Semaphore(0);
        b = new Semaphore(0);
        fb = new Semaphore(0);
        jn = new Semaphore(1);
        semaphores = new Semaphore[15];
        Arrays.fill(semaphores, jn);
        for (int i = 0; i < 15; i++) {
            if (i % 3 == 0) semaphores[i] = f;
            if (i % 5 == 0) semaphores[i] = b;
        }
        semaphores[0] = fb;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (semaphores[i % 15] == f) {
                f.acquire();
                printFizz.run();
                semaphores[(i + 1) % 15].release();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (semaphores[i % 15] == b) {
                b.acquire();
                printBuzz.run();
                semaphores[(i + 1) % 15].release();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (semaphores[i % 15] == fb) {
                fb.acquire();
                printFizzBuzz.run();
                semaphores[(i + 1) % 15].release();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (semaphores[i % 15] == jn) {
                jn.acquire();
                printNumber.accept(i);
                semaphores[(i + 1) % 15].release();
            }
        }
    }
}
