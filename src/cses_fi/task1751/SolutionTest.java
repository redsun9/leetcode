package cses_fi.task1751;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void planetCycles() {
        int[] teleports = {2, 4, 3, 1, 4};
        int[] expected = {3, 3, 1, 3, 4};
        assertArrayEquals(expected, Solution.planetCycles(teleports));
    }
}