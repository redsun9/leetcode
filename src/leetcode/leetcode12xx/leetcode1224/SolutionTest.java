package leetcode.leetcode12xx.leetcode1224;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {2, 2, 1, 1, 5, 3, 3, 5};
        assertEquals(7, new Solution().maxEqualFreq(nums));
    }

    @Test
    void test2() {
        int[] nums = {1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5};
        assertEquals(13, new Solution().maxEqualFreq(nums));
    }

    @Test
    void test3() {
        int[] nums = {1, 1, 1, 2, 2, 2};
        assertEquals(5, new Solution().maxEqualFreq(nums));
    }

    @Test
    void test4() {
        int[] nums = {10, 2, 8, 9, 3, 8, 1, 5, 2, 3, 7, 6};
        assertEquals(8, new Solution().maxEqualFreq(nums));
    }
}