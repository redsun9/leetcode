package leetcode.leetcode19xx.leetcode1909;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {1, 2, 10, 5, 7};
        assertTrue(new Solution().canBeIncreasing(nums));
    }

    @Test
    void test2() {
        int[] nums = {2, 3, 1, 2};
        assertFalse(new Solution().canBeIncreasing(nums));
    }

    @Test
    void test3() {
        int[] nums = {1, 1, 1};
        assertFalse(new Solution().canBeIncreasing(nums));
    }

    @Test
    void test4() {
        int[] nums = {1, 2, 3};
        assertTrue(new Solution().canBeIncreasing(nums));
    }
}