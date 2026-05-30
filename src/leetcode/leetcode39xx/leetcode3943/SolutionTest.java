package leetcode.leetcode39xx.leetcode3943;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums1 = {1, 2}, nums2 = {3, 4};
        int[][] queries = {{2, 5}, {1, 0, 0, 2}, {2, 5}};
        int[] expected = {2, 1};
        assertArrayEquals(expected, new Solution().numberOfPairs(nums1, nums2, queries));
    }

    @Test
    void test2() {
        int[] nums1 = {1, 1}, nums2 = {2, 2, 3};
        int[][] queries = {{2, 4}, {1, 0, 1, 1}, {2, 4}};
        int[] expected = {2, 6};
        assertArrayEquals(expected, new Solution().numberOfPairs(nums1, nums2, queries));
    }
}