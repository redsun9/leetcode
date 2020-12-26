package leetcode.leetcode16xx.leetcode1658;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {1, 1, 4, 2, 3};
        assertEquals(2, new Solution().minOperations(nums, 5));
    }
}