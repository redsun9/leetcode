package leetcode.leetcode15xx.leetcode1509;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {5, 3, 2, 4};
        assertEquals(0, new Solution().minDifference(nums));
    }

    @Test
    void test2() {
        int[] nums = {1, 5, 0, 10, 14};
        assertEquals(1, new Solution().minDifference(nums));
    }

    @Test
    void test3() {
        int[] nums = {6, 6, 0, 1, 1, 4, 6};
        assertEquals(2, new Solution().minDifference(nums));
    }

    @Test
    void test4() {
        int[] nums = {1, 5, 6, 14, 15};
        assertEquals(1, new Solution().minDifference(nums));
    }
}