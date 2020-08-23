package leetcode.leetcode15xx.leetcode1558;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {1, 5};
        assertEquals(5, new Solution().minOperations(nums));
    }

    @Test
    void test2() {
        int[] nums = {2, 2};
        assertEquals(3, new Solution().minOperations(nums));
    }

    @Test
    void test3() {
        int[] nums = {4, 2, 5};
        assertEquals(6, new Solution().minOperations(nums));
    }

    @Test
    void test4() {
        int[] nums = {3, 2, 2, 4};
        assertEquals(7, new Solution().minOperations(nums));
    }

    @Test
    void test5() {
        int[] nums = {2, 4, 8, 16};
        assertEquals(8, new Solution().minOperations(nums));
    }

}