package leetcode.leetcode4xx.leetcode469;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        int[][] points = {{0, 0}, {0, 1}, {1, 1}, {1, 0}};
        assertTrue(new Solution().isConvex(points));
    }

    @Test
    void test2() {
        int[][] points = {{0, 0}, {0, 10}, {10, 10}, {10, 0}, {5, 5}};
        assertFalse(new Solution().isConvex(points));
    }
}