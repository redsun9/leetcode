package leetcode.leetcode18xx.leetcode1856;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {1, 2, 3, 2};
        assertEquals(14, new Solution().maxSumMinProduct(nums));
    }

    @Test
    void test2() {
        int[] nums = {2, 3, 3, 1, 2};
        assertEquals(18, new Solution().maxSumMinProduct(nums));
    }

    @Test
    void test3() {
        int[] nums = {3, 1, 5, 6, 4, 2};
        assertEquals(60, new Solution().maxSumMinProduct(nums));
    }
}