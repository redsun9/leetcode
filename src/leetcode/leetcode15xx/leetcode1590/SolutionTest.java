package leetcode.leetcode15xx.leetcode1590;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {3, 1, 4, 2};
        int p = 6;
        assertEquals(1, new Solution().minSubarray(nums, p));
    }

    @Test
    void test2() {
        int[] nums = {6, 3, 5, 2};
        int p = 9;
        assertEquals(2, new Solution().minSubarray(nums, p));
    }

    @Test
    void test3() {
        int[] nums = {1, 2, 3};
        int p = 3;
        assertEquals(0, new Solution().minSubarray(nums, p));
    }

    @Test
    void test4() {
        int[] nums = {1, 2, 3};
        int p = 7;
        assertEquals(-1, new Solution().minSubarray(nums, p));
    }

    @Test
    void test5() {
        int[] nums = {1000000000, 1000000000, 1000000000};
        int p = 3;
        assertEquals(0, new Solution().minSubarray(nums, p));
    }
}
