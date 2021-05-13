package leetcode.leetcode7xx.leetcode775;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {1, 0, 2};
        assertTrue(new Solution().isIdealPermutation(nums));
    }

    @Test
    void test2() {
        int[] nums = {1, 2, 0};
        assertFalse(new Solution().isIdealPermutation(nums));
    }
}