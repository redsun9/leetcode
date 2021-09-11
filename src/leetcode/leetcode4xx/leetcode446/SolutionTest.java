package leetcode.leetcode4xx.leetcode446;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {2, 4, 6, 8, 10};
        assertEquals(7, new Solution().numberOfArithmeticSlices(nums));
    }

    @Test
    void test2() {
        int[] nums = {7, 7, 7, 7, 7};
        assertEquals(16, new Solution().numberOfArithmeticSlices(nums));
    }
}