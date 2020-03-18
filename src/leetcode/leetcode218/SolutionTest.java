package leetcode.leetcode218;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void getSkyline() {
        Solution solution = new Solution();
        assertEquals(
                Arrays.asList(
                        Arrays.asList(2, 10),
                        Arrays.asList(3, 15),
                        Arrays.asList(7, 12),
                        Arrays.asList(12, 0),
                        Arrays.asList(15, 10),
                        Arrays.asList(20, 8),
                        Arrays.asList(24, 0)
                ),
                solution.getSkyline(
                        new int[][]{
                                {2, 9, 10},
                                {3, 7, 15},
                                {5, 12, 12},
                                {15, 20, 10},
                                {19, 24, 8}
                        }
                )
        );
    }
}