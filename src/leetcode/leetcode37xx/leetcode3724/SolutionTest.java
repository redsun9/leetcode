package leetcode.leetcode37xx.leetcode3724;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void minOperations() {
        int[] nums1 = {2, 8}, nums2 = {1, 7, 3};
        assertEquals(4, new Solution().minOperations(nums1, nums2));
    }
}