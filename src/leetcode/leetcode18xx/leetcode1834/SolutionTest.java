package leetcode.leetcode18xx.leetcode1834;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] tasks = {{1, 2}, {2, 4}, {3, 2}, {4, 1}};
        int[] expected = {0, 2, 3, 1};
        assertArrayEquals(expected, new Solution().getOrder(tasks));
    }

    @Test
    void test2() {
        int[][] tasks = {{7, 10}, {7, 12}, {7, 5}, {7, 4}, {7, 2}};
        int[] expected = {4, 3, 2, 0, 1};
        assertArrayEquals(expected, new Solution().getOrder(tasks));
    }
}