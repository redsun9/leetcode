package leetcode.leetcode17xx.leetcode1793;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {1, 4, 3, 7, 4, 5};
        assertEquals(15, new Solution().maximumScore(nums, 3));
    }

    @Test
    void test2() {
        int[] nums = {5, 5, 4, 5, 4, 1, 1, 1};
        assertEquals(20, new Solution().maximumScore(nums, 0));
    }
}