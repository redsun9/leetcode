package leetcode.leetcode21xx.leetcode2172;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int numSlots = 3, expected = 9;
        assertEquals(expected, new Solution().maximumANDSum(nums, numSlots));
    }

    @Test
    void test2() {
        int[] nums = {1, 3, 10, 4, 7, 1};
        int numSlots = 9, expected = 24;
        assertEquals(expected, new Solution().maximumANDSum(nums, numSlots));
    }
}