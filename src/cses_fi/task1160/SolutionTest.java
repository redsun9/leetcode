package cses_fi.task1160;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void planetQueries() {
        int[] teleporters = {2, 3, 2, 3, 2};
        int[][] queries = {{1, 2}, {1, 3}, {1, 4}};
        int[] expected = {1, 2, -1};
        assertArrayEquals(expected, Solution.planetQueries(teleporters, queries));
    }
}