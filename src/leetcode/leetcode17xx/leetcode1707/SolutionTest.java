package leetcode.leetcode17xx.leetcode1707;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {0, 1, 2, 3, 4};
        int[][] queries = {{3, 1}, {1, 3}, {5, 6}};
        int[] expected = {3, 3, 7};
        assertArrayEquals(expected, new Solution().maximizeXor(nums, queries));
    }

    @Test
    void test2() {
        int[] nums = {5, 2, 4, 6, 6, 3};
        int[][] queries = {{12, 4}, {8, 1}, {6, 3}};
        int[] expected = {15, -1, 5};
        assertArrayEquals(expected, new Solution().maximizeXor(nums, queries));
    }
}