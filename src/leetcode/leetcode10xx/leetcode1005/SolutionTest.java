package leetcode.leetcode10xx.leetcode1005;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {4, 2, 3};
        int k = 1;
        assertEquals(5, new Solution().largestSumAfterKNegations(nums, k));
    }

    @Test
    void test2() {
        int[] nums = {3, -1, 0, 2};
        int k = 3;
        assertEquals(6, new Solution().largestSumAfterKNegations(nums, k));
    }

    @Test
    void test3() {
        int[] nums = {2, -3, -1, 5, -4};
        int k = 2;
        assertEquals(13, new Solution().largestSumAfterKNegations(nums, k));
    }
}