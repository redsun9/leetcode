package leetcode.leetcode32xx.leetcode3257;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] board = {{-3, 1, 1, 1}, {-3, 1, -3, 1}, {-3, 2, 1, 1}};
        assertEquals(4, new Solution().maximumValueSum(board));
    }

    @Test
    void test2() {
        int[][] board = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertEquals(15, new Solution().maximumValueSum(board));
    }

    @Test
    void test3() {
        int[][] board = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        assertEquals(3, new Solution().maximumValueSum(board));
    }

    @Test
    void test4() {
        int[][] board = {{-28, 85, -51}, {10, -54, 87}, {-78, -92, 38}};
        assertEquals(133, new Solution().maximumValueSum(board));
    }
}