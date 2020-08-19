package leetcode.leetcode8xx.leetcode850;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] rectangles = {{0, 0, 2, 2}, {1, 0, 2, 3}, {1, 0, 3, 1}};
        assertEquals(6, new Solution().rectangleArea(rectangles));
        assertEquals(6, new Solution2().rectangleArea(rectangles));
        assertEquals(6, new Solution3().rectangleArea(rectangles));
    }

    @Test
    void test2() {
        int[][] rectangles = {{25, 20, 70, 27}, {68, 80, 79, 100}, {37, 41, 66, 76}};
        assertEquals(1550, new Solution().rectangleArea(rectangles));
        assertEquals(1550, new Solution2().rectangleArea(rectangles));
        assertEquals(1550, new Solution3().rectangleArea(rectangles));
    }
}