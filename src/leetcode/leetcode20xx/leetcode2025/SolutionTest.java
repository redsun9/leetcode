package leetcode.leetcode20xx.leetcode2025;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {2, -1, 2};
        int k = 3;
        assertEquals(1, new Solution().waysToPartition(nums, k));
    }

    @Test
    void test2() {
        int[] nums = {0, 0, 0};
        int k = 1;
        assertEquals(2, new Solution().waysToPartition(nums, k));
    }

    @Test
    void test3() {
        int[] nums = {22, 4, -25, -20, -15, 15, -16, 7, 19, -10, 0, -13, -14};
        int k = -33;
        assertEquals(4, new Solution().waysToPartition(nums, k));
    }
}