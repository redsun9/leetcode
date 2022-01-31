package leetcode.leetcode21xx.leetcode2132;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        int[][] grid = {{1, 0, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 0}};
        int stampHeight = 4, stampWidth = 3;
        assertTrue(new Solution().possibleToStamp(grid, stampHeight, stampWidth));
    }

    @Test
    void test2() {
        int[][] grid = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        int stampHeight = 2, stampWidth = 2;
        assertFalse(new Solution().possibleToStamp(grid, stampHeight, stampWidth));
    }
}