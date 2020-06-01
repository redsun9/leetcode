package leetcode.leetcode12xx.leetcode1293;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] grid = {
                {0, 0, 0},
                {1, 1, 0},
                {0, 0, 0},
                {0, 1, 1},
                {0, 0, 0}
        };
        assertEquals(6, new Solution().shortestPath(grid, 1));
    }

    @Test
    void test2() {
        int[][] grid = {
                {0, 1, 1},
                {1, 1, 1},
                {1, 0, 0},
        };
        assertEquals(-1, new Solution().shortestPath(grid, 1));
    }
}