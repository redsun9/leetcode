package tinkoff.xor_combination;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    private static final int MIN_N = 2, MAX_N = 100, MIN_M = 1, MAX_M = 1000;

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
    @Disabled
    void testCorrectness() {
        IntStream.rangeClosed(MIN_N, MAX_N).parallel().forEach(n ->
                IntStream.rangeClosed(MIN_M, MAX_M).parallel().forEach(m ->
                        assertEquals(Solution.solve(n, m * 2), Solution2.solve(n, m * 2))
                )
        );
    }

    //90563622400
    //448972200
    @Test
    @Disabled
    void testPerf() {
        long startTime, endTime;

        startTime = System.nanoTime();
        IntStream.rangeClosed(MIN_N, MAX_N).parallel().forEach(n ->
                IntStream.rangeClosed(MIN_M, MAX_M).parallel().forEach(m ->
                        Solution.solve(n, m * 2)
                )
        );
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        startTime = System.nanoTime();
        IntStream.rangeClosed(MIN_N, MAX_N).parallel().forEach(n ->
                IntStream.rangeClosed(MIN_M, MAX_M).parallel().forEach(m ->
                        Solution2.solve(n, m * 2)
                )
        );
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }
}