package leetcode.leetcode17xx.leetcode1769;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] expected = {1, 1, 3};
        assertArrayEquals(expected, new Solution().minOperations("110"));
    }

    @Test
    void test2() {
        int[] expected = {11, 8, 5, 4, 3, 4};
        assertArrayEquals(expected, new Solution().minOperations("001011"));
    }
}