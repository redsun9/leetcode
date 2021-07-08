package leetcode.leetcode7xx.leetcode718;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums1 = {1, 2, 3, 2, 1}, nums2 = {3, 2, 1, 4, 7};
        assertEquals(3, new Solution().findLength(nums1, nums2));
    }
}