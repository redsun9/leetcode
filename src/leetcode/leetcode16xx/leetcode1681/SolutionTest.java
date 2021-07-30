package leetcode.leetcode16xx.leetcode1681;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {1, 2, 1, 4};
        int k = 2;
        assertEquals(4, new Solution().minimumIncompatibility(nums, k));
    }

    @Test
    void test2() {
        int[] nums = {6, 3, 8, 1, 3, 1, 2, 2};
        int k = 4;
        assertEquals(6, new Solution().minimumIncompatibility(nums, k));
    }

    @Test
    void test3() {
        int[] nums = {5, 3, 3, 6, 3, 3};
        int k = 3;
        assertEquals(-1, new Solution().minimumIncompatibility(nums, k));
    }
}