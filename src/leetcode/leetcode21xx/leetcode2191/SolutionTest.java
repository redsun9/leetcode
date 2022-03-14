package leetcode.leetcode21xx.leetcode2191;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
    @Test
    void test1() {
        int[] mapping = {8, 9, 4, 0, 2, 1, 3, 5, 7, 6}, nums = {991, 338, 38}, expected = {338, 38, 991};
        assertArrayEquals(expected, new Solution().sortJumbled(mapping, nums));
    }

    @Test
    void test2() {
        int[] mapping = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, nums = {789, 456, 123}, expected = {123, 456, 789};
        assertArrayEquals(expected, new Solution().sortJumbled(mapping, nums));
    }
}