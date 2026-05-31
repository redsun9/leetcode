package leetcode.leetcode32xx.leetcode3266;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {2, 1, 3, 5, 6};
        int k = 5;
        int multiplier = 2;
        int[] expected = {8, 4, 6, 5, 6};
        assertArrayEquals(expected, new Solution().getFinalState(nums, k, multiplier));
    }

    @Test
    void test2() {
        int[] nums = {100000, 2000};
        int k = 2;
        int multiplier = 1000000;
        int[] expected = {999999307, 999999993};
        assertArrayEquals(expected, new Solution().getFinalState(nums, k, multiplier));
    }
}