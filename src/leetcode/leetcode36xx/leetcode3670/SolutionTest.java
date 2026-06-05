package leetcode.leetcode36xx.leetcode3670;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        assertEquals(12L, new Solution().maxProduct(nums));
    }

    @Test
    void test2() {
        int[] nums = {5, 6, 4};
        assertEquals(0L, new Solution().maxProduct(nums));
    }

    @Test
    void test3() {
        int[] nums = {64, 8, 32};
        assertEquals(2048L, new Solution().maxProduct(nums));
    }
}