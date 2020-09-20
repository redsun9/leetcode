package leetcode.leetcode15xx.leetcode1594;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] grid = {
                {-1, -2, -3},
                {-2, -3, -3},
                {-3, -3, -2}
        };
        assertEquals(-1, new Solution().maxProductPath(grid));
    }

    @Test
    void test2() {
        int[][] grid = {
                {1, -2, 1},
                {1, -2, 1},
                {3, -4, 1}
        };
        assertEquals(8, new Solution().maxProductPath(grid));
    }

    @Test
    void test3() {
        int[][] grid = {
                {1, 3},
                {0, -4}
        };
        assertEquals(0, new Solution().maxProductPath(grid));
    }

    @Test
    void test4() {
        int[][] grid = {
                {1, 4, 4, 0},
                {-2, 0, 0, 1},
                {1, -1, 1, 1}
        };
        assertEquals(2, new Solution().maxProductPath(grid));
    }
}
