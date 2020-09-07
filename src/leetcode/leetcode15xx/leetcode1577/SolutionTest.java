package leetcode.leetcode15xx.leetcode1577;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums1 = {7, 4}, nums2 = {5, 2, 8, 9};
        assertEquals(1, new Solution().numTriplets(nums1, nums2));
    }

    @Test
    void test2() {
        int[] nums1 = {1, 1}, nums2 = {1, 1, 1};
        assertEquals(9, new Solution().numTriplets(nums1, nums2));
    }

    @Test
    void test3() {
        int[] nums1 = {7, 7, 8, 3}, nums2 = {1, 2, 9, 7};
        assertEquals(2, new Solution().numTriplets(nums1, nums2));
    }

    @Test
    void test4() {
        int[] nums1 = {4, 7, 9, 11, 23}, nums2 = {3, 5, 1024, 12, 18};
        assertEquals(0, new Solution().numTriplets(nums1, nums2));
    }

}