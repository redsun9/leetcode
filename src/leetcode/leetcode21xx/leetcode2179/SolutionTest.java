package leetcode.leetcode21xx.leetcode2179;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums1 = {2, 0, 1, 3}, nums2 = {0, 1, 2, 3};
        assertEquals(1, new Solution().goodTriplets(nums1, nums2));
    }

    @Test
    void test2() {
        int[] nums1 = {4, 0, 1, 3, 2}, nums2 = {4, 1, 0, 2, 3};
        assertEquals(4, new Solution().goodTriplets(nums1, nums2));
    }
}