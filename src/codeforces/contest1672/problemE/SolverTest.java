package codeforces.contest1672.problemE;

import org.junit.jupiter.api.Test;
import stress.StressTester;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolverTest {
    private static final int MAX_WORDS = 2000;
    private static final int MAX_LEN = 2000;


    @Test
    void test1() {
        int[] words = {5, 2, 7, 3, 5, 6};
        GraderImpl grader = new GraderImpl(words);
        Solver solver = new Solver(grader);
        solver.solve();
        assertTrue(grader.iSolved());
        assertTrue(grader.getNumberOfTries() <= words.length + 30);
    }

    @Test
    void test2() {
        int[] words = {2000, 2000};
        GraderImpl grader = new GraderImpl(words);
        Solver solver = new Solver(grader);
        solver.solve();
        assertTrue(grader.iSolved());
        assertTrue(grader.getNumberOfTries() <= words.length + 30);
    }

    @Test
    void testRandom() throws InterruptedException {
        StressTester.exactStressTest(
                seed -> {
                    Random random = new Random(seed);
                    int[] words = new int[MAX_WORDS];
                    for (int i = 0; i < words.length; i++) words[i] = 1 + random.nextInt(MAX_LEN);
                    return words;
                },
                (words) -> {
                    GraderImpl grader = new GraderImpl(words);
                    Solver solver = new Solver(grader);
                    solver.solve();
                    return grader.iSolved() && grader.getNumberOfTries() <= words.length + 30;
                },
                (words) -> true
        );
    }
}