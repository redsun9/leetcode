package leetcode.leetcode17xx.leetcode1799;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {1, 2};
        assertEquals(1, new Solution().maxScore(nums));
    }

    @Test
    void test2() {
        int[] nums = {3, 4, 6, 8};
        assertEquals(11, new Solution().maxScore(nums));
    }

    @Test
    void test3() {
        int[] nums = {1, 2, 3, 4, 5, 6};
        assertEquals(14, new Solution().maxScore(nums));
    }
}