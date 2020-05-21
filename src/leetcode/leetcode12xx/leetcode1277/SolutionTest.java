package leetcode.leetcode12xx.leetcode1277;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] matrix = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        };
        assertEquals(15, new Solution().countSquares(matrix));
    }

    @Test
    void test2() {
        int[][] matrix = {
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        };
        assertEquals(7, new Solution().countSquares(matrix));
    }
}