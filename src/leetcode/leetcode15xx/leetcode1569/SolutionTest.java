package leetcode.leetcode15xx.leetcode1569;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {2, 1, 3};
        assertEquals(1, new Solution().numOfWays(nums));
    }

    @Test
    void test2() {
        int[] nums = {3, 4, 5, 1, 2};
        assertEquals(5, new Solution().numOfWays(nums));
    }

    @Test
    void test3() {
        int[] nums = {1, 2, 3};
        assertEquals(0, new Solution().numOfWays(nums));
    }

    @Test
    void test4() {
        int[] nums = {3, 1, 2, 5, 4, 6};
        assertEquals(19, new Solution().numOfWays(nums));
    }

    @Test
    void test5() {
        int[] nums = {9, 4, 2, 1, 3, 6, 5, 7, 8, 14, 11, 10, 12, 13, 16, 15, 17, 18};
        assertEquals(216212978, new Solution().numOfWays(nums));
    }
}