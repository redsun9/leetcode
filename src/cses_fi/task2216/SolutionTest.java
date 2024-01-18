package cses_fi.task2216;

import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.Random;

class SolutionTest {
    private static final int N = 100;
    private static final int MAX_VAL = 10;

    @Test
    void numberOfRounds() throws InterruptedException {
        StressTester.exactStressTest(
                this::generate,
                DummySolution::numberOfRounds,
                Solution::numberOfRounds,
                1_000_000,
                1,
                100_000
        );
    }

    private int[] generate(long seed) {
        int[] arr = new int[N];
        Random random = new Random(seed);
        for (int i = 0; i < N; i++) arr[i] = random.nextInt(MAX_VAL);
        return arr;
    }
}