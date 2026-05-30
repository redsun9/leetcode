package leetcode.leetcode39xx.leetcode3938;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] grid = {{1, 2, 0, -3}, {1, -2, 1, 0}, {-4, 2, -1, 3}, {3, -3, 3, -2}, {-1, -5, 0, 1}};
        assertEquals(4, new Solution().maxScore(grid));
    }

    @Test
    void test2() {
        int[][] grid = {{4, -2, -3}, {-1, -3, -1}, {-4, 2, -1}};
        assertEquals(3, new Solution().maxScore(grid));
    }
}