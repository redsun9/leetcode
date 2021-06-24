package leetcode.leetcode19xx.leetcode1906;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {1, 3, 4, 8};
        int[][] queries = {{0, 1}, {1, 2}, {2, 3}, {0, 3}};
        int[] expected = {2, 1, 4, 1};
        assertArrayEquals(expected, new Solution().minDifference(nums, queries));
    }

    @Test
    void test2() {
        int[] nums = {4, 5, 2, 2, 7, 10};
        int[][] queries = {{2, 3}, {0, 2}, {0, 5}, {3, 5}};
        int[] expected = {-1, 1, 1, 3};
        assertArrayEquals(expected, new Solution().minDifference(nums, queries));
    }
}