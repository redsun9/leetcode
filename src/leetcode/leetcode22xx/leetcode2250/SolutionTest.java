package leetcode.leetcode22xx.leetcode2250;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
    @Test
    void test1() {
        int[][] rectangles = {{1, 2}, {2, 3}, {2, 5}}, points = {{2, 1}, {1, 4}};
        int[] expected = {2, 1};
        assertArrayEquals(expected, new Solution().countRectangles(rectangles, points));
    }

    @Test
    void test2() {
        int[][] rectangles = {{1, 1}, {2, 2}, {3, 3}}, points = {{1, 3}, {1, 1}};
        int[] expected = {1, 3};
        assertArrayEquals(expected, new Solution().countRectangles(rectangles, points));
    }
}