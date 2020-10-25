package leetcode.leetcode16xx.leetcode1632;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        int[][] matrix = {{1, 2}, {3, 4}};
        int[][] expected = {{1, 2}, {2, 3}};
        assertTrue(Arrays.deepEquals(expected, new Solution().matrixRankTransform(matrix)));
    }

    @Test
    void test2() {
        int[][] matrix = {{7, 7}, {7, 7}};
        int[][] expected = {{1, 1}, {1, 1}};
        assertTrue(Arrays.deepEquals(expected, new Solution().matrixRankTransform(matrix)));
    }

    @Test
    void test3() {
        int[][] matrix = {{20, -21, 14}, {-19, 4, 19}, {22, -47, 24}, {-19, 4, 19}};
        int[][] expected = {{4, 2, 3}, {1, 3, 4}, {5, 1, 6}, {1, 3, 4}};
        assertTrue(Arrays.deepEquals(expected, new Solution().matrixRankTransform(matrix)));
    }

    @Test
    void test4() {
        int[][] matrix = {{7, 3, 6}, {1, 4, 5}, {9, 8, 2}};
        int[][] expected = {{5, 1, 4}, {1, 2, 3}, {6, 3, 1}};
        assertTrue(Arrays.deepEquals(expected, new Solution().matrixRankTransform(matrix)));
    }

}