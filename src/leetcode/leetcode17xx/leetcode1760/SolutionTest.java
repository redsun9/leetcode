package leetcode.leetcode17xx.leetcode1760;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {9};
        assertEquals(3, new Solution().minimumSize(nums, 2));
    }

    @Test
    void test2() {
        int[] nums = {2, 4, 8, 2};
        assertEquals(2, new Solution().minimumSize(nums, 4));
    }

    @Test
    void test3() {
        int[] nums = {7, 17};
        assertEquals(7, new Solution().minimumSize(nums, 2));
    }
}