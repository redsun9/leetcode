package leetcode.leetcode18xx.leetcode1886;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        int[][] mat = {{0, 1}, {1, 0}}, target = {{1, 0}, {0, 1}};
        assertTrue(new Solution().findRotation(mat, target));
    }

    @Test
    void test2() {
        int[][] mat = {{0, 1}, {1, 1}}, target = {{1, 0}, {0, 1}};
        assertFalse(new Solution().findRotation(mat, target));
    }

    @Test
    void test3() {
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}}, target = {{1, 1, 1}, {0, 1, 0}, {0, 0, 0}};
        assertTrue(new Solution().findRotation(mat, target));
    }
}