package tinkoff.XorCombination;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    private static final int MAX_N = 10, MAX_M = 5000;

    @Test
    void test1() {
        assertEquals(1, Solution.solve(2, 2));
        assertEquals(1, Solution2.solve(2, 2));
    }

    @Test
    void test2() {
        assertEquals(15, Solution.solve(5, 4));
        assertEquals(15, Solution2.solve(5, 4));
    }

    @Test
    void test3() {
        assertEquals(475, Solution.solve(5, 20));
        assertEquals(475, Solution2.solve(5, 20));
    }

    @Test
    void testCorrectness() {
        IntStream.rangeClosed(1, MAX_N).parallel().forEach(n ->
                IntStream.rangeClosed(1, MAX_M).parallel().forEach(m ->
                        assertEquals(Solution.solve(n, m), Solution2.solve(n, m))
                )
        );
    }

    //31032118600
    //  514195600
    @Test
    void testPerf() {
        long startTime = System.nanoTime();
        IntStream.rangeClosed(1, MAX_N).parallel().forEach(n ->
                IntStream.rangeClosed(1, MAX_M).parallel().forEach(m ->
                        Solution.solve(n, m)
                )
        );
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        startTime = System.nanoTime();
        IntStream.rangeClosed(1, MAX_N).parallel().forEach(n ->
                IntStream.rangeClosed(1, MAX_M).parallel().forEach(m ->
                        Solution2.solve(n, m)
                )
        );
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }
}