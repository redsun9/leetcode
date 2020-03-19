package leetcode.leetcode1117;

public interface H2O {
    void hydrogen(Runnable releaseHydrogen) throws InterruptedException;

    void oxygen(Runnable releaseOxygen) throws InterruptedException;
}
