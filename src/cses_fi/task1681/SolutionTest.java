package cses_fi.task1681;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void numberOfWays() {
        int[][] teleporters = {{1, 2}, {2, 4}, {1, 3}, {3, 4}, {1, 4}};
        assertEquals(3, Solution.numberOfWays(4, teleporters));
    }
}