package leetcode.leetcode2xx.leetcode215;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {3, 2, 1, 5, 6, 4};
        assertEquals(5, new Solution().findKthLargest(nums, 2));
    }

    @Test
    void test2() {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        assertEquals(4, new Solution().findKthLargest(nums, 4));
    }
}