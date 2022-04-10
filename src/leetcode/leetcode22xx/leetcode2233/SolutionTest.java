package leetcode.leetcode22xx.leetcode2233;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {0, 4};
        int k = 5, expected = 20;
        assertEquals(expected, new Solution().maximumProduct(nums, k));
    }

    @Test
    void test2() {
        int[] nums = {6, 3, 3, 2};
        int k = 2, expected = 216;
        assertEquals(expected, new Solution().maximumProduct(nums, k));
    }

}