package leetcode.leetcode39xx.leetcode3933;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] matrix = {{0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 2, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}};
        assertEquals(1, new Solution().countLocalMaximums(matrix));
    }

    @Test
    void test2() {
        int[][] matrix = {{1, 2}, {3, 4}};
        assertEquals(1, new Solution().countLocalMaximums(matrix));
    }

    @Test
    void test3() {
        int[][] matrix = {{1, 0, 1}, {0, 1, 0}, {1, 0, 1}};
        assertEquals(5, new Solution().countLocalMaximums(matrix));
    }

    @Test
    void test4() {
        int[][] matrix = {{1, 1}, {1, 1}};
        assertEquals(4, new Solution().countLocalMaximums(matrix));
    }
}