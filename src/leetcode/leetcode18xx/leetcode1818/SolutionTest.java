package leetcode.leetcode18xx.leetcode1818;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums1 = {1, 7, 5}, nums2 = {2, 3, 5};
        assertEquals(3, new Solution().minAbsoluteSumDiff(nums1, nums2));
    }

    @Test
    void test2() {
        int[] nums1 = {2, 4, 6, 8, 10}, nums2 = {2, 4, 6, 8, 10};
        assertEquals(0, new Solution().minAbsoluteSumDiff(nums1, nums2));
    }

    @Test
    void test3() {
        int[] nums1 = {1, 10, 4, 4, 2, 7}, nums2 = {9, 3, 5, 1, 7, 4};
        assertEquals(20, new Solution().minAbsoluteSumDiff(nums1, nums2));
    }
}