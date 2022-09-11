package leetcode.leetcode24xx.leetcode2407;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {4, 2, 1, 4, 3, 4, 5, 8, 15};
        int k = 3, expected = 5;
        assertEquals(expected, new Solution().lengthOfLIS(nums, k));
    }

    @Test
    void test2() {
        int[] nums = {7, 4, 5, 1, 8, 12, 4, 7};
        int k = 5, expected = 4;
        assertEquals(expected, new Solution().lengthOfLIS(nums, k));
    }

    @Test
    void test3() {
        int[] nums = {1, 5};
        int k = 1, expected = 1;
        assertEquals(expected, new Solution().lengthOfLIS(nums, k));
    }
}