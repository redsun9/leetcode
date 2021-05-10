package leetcode.leetcode17xx.leetcode1755;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {5, -7, 3, 5};
        int goal = 6;
        assertEquals(0, new Solution().minAbsDifference(nums, goal));
    }

    @Test
    void test2() {
        int[] nums = {7, -9, 15, -2};
        int goal = -5;
        assertEquals(1, new Solution().minAbsDifference(nums, goal));
    }

    @Test
    void test3() {
        int[] nums = {1, 2, 3};
        int goal = -7;
        assertEquals(7, new Solution().minAbsDifference(nums, goal));
    }
}