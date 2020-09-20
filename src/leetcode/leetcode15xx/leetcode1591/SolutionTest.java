package leetcode.leetcode15xx.leetcode1591;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        int[][] targetGrid = {{1, 1, 1, 1}, {1, 2, 2, 1}, {1, 2, 2, 1}, {1, 1, 1, 1}};
        assertTrue(new Solution().isPrintable(targetGrid));
    }

    @Test
    void test2() {
        int[][] targetGrid = {{1, 1, 1, 1}, {1, 1, 3, 3}, {1, 1, 3, 4}, {5, 5, 1, 4}};
        assertTrue(new Solution().isPrintable(targetGrid));
    }

    @Test
    void test3() {
        int[][] targetGrid = {{1, 2, 1}, {2, 1, 2}, {1, 2, 1}};
        assertFalse(new Solution().isPrintable(targetGrid));
    }

    @Test
    void test4() {
        int[][] targetGrid = {{1, 1, 1}, {3, 1, 3}};
        assertFalse(new Solution().isPrintable(targetGrid));
    }

    @Test
    void test5() {
        int[][] targetGrid = {{5, 1, 5, 3, 5}, {4, 4, 4, 3, 4}, {5, 1, 5, 3, 5}, {2, 1, 2, 2, 2}, {5, 1, 5, 3, 5}};
        assertFalse(new Solution().isPrintable(targetGrid));
    }
}
