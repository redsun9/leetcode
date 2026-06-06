package leetcode.leetcode31xx.leetcode3165;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {3, 5, 9};
        int[][] queries = {{1, -2}, {0, -3}};
        assertEquals(21, new Solution().maximumSumSubsequence(nums, queries));
    }
}