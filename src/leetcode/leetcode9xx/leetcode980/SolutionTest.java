package leetcode.leetcode9xx.leetcode980;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] grid = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
        assertEquals(2, new Solution().uniquePathsIII(grid));
    }

    @Test
    void test2() {
        int[][] grid = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}};
        assertEquals(4, new Solution().uniquePathsIII(grid));
    }

    @Test
    void test3() {
        int[][] grid = {{0, 1}, {2, 0}};
        assertEquals(0, new Solution().uniquePathsIII(grid));
    }


}