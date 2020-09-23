package leetcode.leetcode0xx.leetcode4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums1 = {1};
        int[] nums2 = {2, 3};
        assertEquals(2.0, new Solution().findMedianSortedArrays(nums1, nums2));
    }
}