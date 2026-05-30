package leetcode.leetcode39xx.leetcode3937;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {1, 4, 2, 8};
        int k = 3, expected = 2;
        assertEquals(expected, new Solution().minOperations(nums, k));
    }

    @Test
    void test2() {
        int[] nums = {1, 1, 1};
        int k = 3, expected = 1;
        assertEquals(expected, new Solution().minOperations(nums, k));
    }
}