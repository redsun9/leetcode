package leetcode.leetcode22xx.leetcode2258;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] grid = {{0, 2, 0, 0, 0, 0, 0}, {0, 0, 0, 2, 2, 1, 0}, {0, 2, 0, 0, 1, 2, 0}, {0, 0, 2, 2, 2, 0, 2}, {0, 0, 0, 0, 0, 0, 0}};
        assertEquals(3, new Solution().maximumMinutes(grid));
    }

    @Test
    void test2() {
        int[][] grid = {{0, 0, 0, 0}, {0, 1, 2, 0}, {0, 2, 0, 0}};
        assertEquals(-1, new Solution().maximumMinutes(grid));
    }

    @Test
    void test3() {
        int[][] grid = {{0, 0, 0}, {2, 2, 0}, {1, 2, 0}};
        assertEquals(1_000_000_000, new Solution().maximumMinutes(grid));

    }
}