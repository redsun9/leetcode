package leetcode.leetcode9xx.leetcode910;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {1};
        int k = 0;
        assertEquals(0, new Solution().smallestRangeII(nums, k));
    }

    @Test
    void test2() {
        int[] nums = {0, 10};
        int k = 2;
        assertEquals(6, new Solution().smallestRangeII(nums, k));
    }

    @Test
    void test3() {
        int[] nums = {1, 3, 6};
        int k = 3;
        assertEquals(3, new Solution().smallestRangeII(nums, k));
    }
}