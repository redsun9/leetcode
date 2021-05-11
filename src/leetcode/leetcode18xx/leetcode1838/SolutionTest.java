package leetcode.leetcode18xx.leetcode1838;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {1, 2, 4};
        int k = 5, expected = 3;
        assertEquals(expected, new Solution().maxFrequency(nums, k));
    }

    @Test
    void test2() {
        int[] nums = {1, 4, 8, 13};
        int k = 5, expected = 2;
        assertEquals(expected, new Solution().maxFrequency(nums, k));
    }

    @Test
    void test3() {
        int[] nums = {3, 9, 6};
        int k = 2, expected = 1;
        assertEquals(expected, new Solution().maxFrequency(nums, k));
    }
}