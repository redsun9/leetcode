package leetcode.leetcode1226;

import java.util.concurrent.Semaphore;

public class DiningPhilosophers {
    private Semaphore[] sems;
    private int n;

    public DiningPhilosophers() {
        this.n = 5;
        this.sems = new Semaphore[n];
        for (int i = 0; i < n; i++) {
            sems[i] = new Semaphore(1);
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        if (philosopher < n - 1) {
            sems[philosopher].acquire();
            sems[philosopher + 1].acquire();
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putRightFork.run();
            putLeftFork.run();
            sems[philosopher].release();
            sems[philosopher + 1].release();
        } else {
            sems[0].acquire();
            sems[n - 1].acquire();
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putRightFork.run();
            putLeftFork.run();
            sems[0].release();
            sems[n - 1].release();
        }
    }
}
