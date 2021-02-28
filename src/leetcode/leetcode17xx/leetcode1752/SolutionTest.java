package leetcode.leetcode17xx.leetcode1752;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {3, 4, 5, 1, 2};
        assertTrue(new Solution().check(nums));
    }

    @Test
    void test2() {
        int[] nums = {2, 1, 3, 4};
        assertFalse(new Solution().check(nums));
    }

    @Test
    void test3() {
        int[] nums = {1, 2, 3};
        assertTrue(new Solution().check(nums));
    }

    @Test
    void test4() {
        int[] nums = {1, 1, 1};
        assertTrue(new Solution().check(nums));
    }

    @Test
    void test5() {
        int[] nums = {2, 1};
        assertTrue(new Solution().check(nums));
    }
}