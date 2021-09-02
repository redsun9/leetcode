package tinkoff.XorCombination;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(1, Solution.solve(2, 2));
    }

    @Test
    void test2() {
        assertEquals(15, Solution.solve(5, 4));
    }

    @Test
    void test3() {
        assertEquals(475, Solution.solve(5, 20));
    }
}