package leetcode.leetcode18xx.leetcode1877;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {3, 5, 2, 3};
        assertEquals(7, new Solution().minPairSum(nums));
    }

    @Test
    void test2() {
        int[] nums = {3, 5, 4, 2, 4, 6};
        assertEquals(8, new Solution().minPairSum(nums));
    }
}