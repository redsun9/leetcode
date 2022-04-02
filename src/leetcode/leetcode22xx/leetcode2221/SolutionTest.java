package leetcode.leetcode22xx.leetcode2221;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {1, 2, 3, 4, 5};
        assertEquals(8, new Solution().triangularSum(nums));
    }

    @Test
    void test2() {
        int[] nums = {5};
        assertEquals(5, new Solution().triangularSum(nums));
    }
}