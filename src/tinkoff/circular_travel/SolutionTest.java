package tinkoff.circular_travel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] edges = {{1, 2}};
        assertEquals(4, Solution.solve(edges, 3, 4));
    }

    @Test
    void test2() {
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
        assertEquals(0, Solution.solve(edges, 3, 3));
    }
}