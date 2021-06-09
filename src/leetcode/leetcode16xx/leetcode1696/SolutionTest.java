package leetcode.leetcode16xx.leetcode1696;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {1, -1, -2, 4, -7, 3};
        int k = 2;
        assertEquals(7, new Solution().maxResult(nums, k));
        assertEquals(7, new Solution2().maxResult(nums, k));
    }

    @Test
    void test2() {
        int[] nums = {10, -5, -2, 4, 0, 3};
        int k = 3;
        assertEquals(17, new Solution().maxResult(nums, k));
        assertEquals(17, new Solution2().maxResult(nums, k));
    }

    @Test
    void test3() {
        int[] nums = {1, -5, -20, 4, -1, 3, -6, -3};
        int k = 2;
        assertEquals(0, new Solution().maxResult(nums, k));
        assertEquals(0, new Solution2().maxResult(nums, k));
    }
}