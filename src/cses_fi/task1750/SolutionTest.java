package cses_fi.task1750;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void planetQueries() {
        int[] teleports = {2, 1, 1, 4};
        int[][] queries = {{1, 2}, {3, 4}, {4, 1}};
        int[] expected = {1, 2, 4};
        assertArrayEquals(expected, Solution.planetQueries(teleports, queries));
    }
}