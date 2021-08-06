package leetcode.leetcode10xx.leetcode1031;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {0, 6, 5, 2, 2, 5, 1, 9, 4};
        int firstLen = 1, secondLen = 2;
        assertEquals(20, new Solution().maxSumTwoNoOverlap(nums, firstLen, secondLen));
    }

    @Test
    void test2() {
        int[] nums = {3, 8, 1, 3, 2, 1, 8, 9,};
        int firstLen = 3, secondLen = 2;
        assertEquals(29, new Solution().maxSumTwoNoOverlap(nums, firstLen, secondLen));
    }

    @Test
    void test3() {
        int[] nums = {2, 1, 5, 6, 0, 9, 5, 0, 3, 8};
        int firstLen = 4, secondLen = 3;
        assertEquals(31, new Solution().maxSumTwoNoOverlap(nums, firstLen, secondLen));
    }
}