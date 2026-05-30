package leetcode.leetcode39xx.leetcode3934;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {3, 3, 3};
        assertEquals(3, new Solution().smallestUniqueSubarray(nums));
    }

    @Test
    void test2() {
        int[] nums = {2, 1, 2, 3, 3};
        assertEquals(1, new Solution().smallestUniqueSubarray(nums));
    }
}