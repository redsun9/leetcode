package leetcode.leetcode18xx.leetcode1878;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] grid = {{3, 4, 5, 1, 3}, {3, 3, 4, 2, 3}, {20, 30, 200, 40, 10}, {1, 5, 5, 4, 1}, {4, 3, 2, 2, 5}};
        int[] expected = {228, 216, 211};
        assertArrayEquals(expected, new Solution().getBiggestThree(grid));
    }

    @Test
    void test2() {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] expected = {20, 9, 8};
        assertArrayEquals(expected, new Solution().getBiggestThree(grid));
    }

    @Test
    void test3() {
        int[][] grid = {{7, 7, 7}};
        int[] expected = {7};
        assertArrayEquals(expected, new Solution().getBiggestThree(grid));
    }

    @Test
    void test4() {
        int[][] grid = new int[50][50];
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                grid[i][j] = 1 << ((51 + j - i) % 17);
            }
        }
        int[] expected = {2490366, 1818622, 1781586};
        assertArrayEquals(expected, new Solution().getBiggestThree(grid));
    }
}