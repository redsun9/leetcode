package leetcode.leetcode38xx.leetcode3854;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {-2, -3, 1, 4};
        int[] expected = {2, 6};
        assertArrayEquals(expected, new Solution().makeParityAlternating(nums));
    }

    @Test
    void test2() {
        int[] nums = {0, 2, -2};
        int[] expected = {1, 3};
        assertArrayEquals(expected, new Solution().makeParityAlternating(nums));
    }
}