package leetcode.leetcode18xx.leetcode1803;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {1, 4, 2, 7};
        int low = 2, high = 6;
        assertEquals(6, new Solution().countPairs(nums, low, high));
    }

    @Test
    void test2() {
        int[] nums = {9, 8, 4, 2, 1};
        int low = 5, high = 14;
        assertEquals(8, new Solution().countPairs(nums, low, high));
    }
}