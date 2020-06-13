package leetcode.leetcode13xx.leetcode1391;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        int[][] grid = {{2, 4, 3}, {6, 5, 2}};
        assertTrue(new Solution().hasValidPath(grid));
    }
}