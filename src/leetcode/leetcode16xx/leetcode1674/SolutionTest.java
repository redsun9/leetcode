package leetcode.leetcode16xx.leetcode1674;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {1, 2, 4, 3};
        assertEquals(1, new Solution().minMoves(nums, 4));
    }
}