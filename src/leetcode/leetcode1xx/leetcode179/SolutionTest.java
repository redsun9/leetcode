package leetcode.leetcode1xx.leetcode179;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {10, 2};
        assertEquals("210", new Solution().largestNumber(nums));
        assertEquals("210", new Solution2().largestNumber(nums));
    }

    @Test
    void test2() {
        int[] nums = {3, 30, 34, 5, 9};
        assertEquals("9534330", new Solution().largestNumber(nums));
        assertEquals("9534330", new Solution2().largestNumber(nums));
    }
}