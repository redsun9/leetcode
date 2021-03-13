package leetcode.leetcode17xx.leetcode1770;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {1, 2, 3};
        int[] multipliers = {3, 2, 1};
        assertEquals(14, new Solution().maximumScore(nums, multipliers));
    }

    @Test
    void test2() {
        int[] nums = {-5, -3, -3, -2, 7, 1};
        int[] multipliers = {-10, -5, 3, 4, 6};
        assertEquals(102, new Solution().maximumScore(nums, multipliers));
    }
}