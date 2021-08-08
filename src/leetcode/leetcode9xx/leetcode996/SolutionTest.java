package leetcode.leetcode9xx.leetcode996;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {1, 17, 8};
        assertEquals(2, new Solution().numSquarefulPerms(nums));
    }

    @Test
    void test2() {
        int[] nums = {2, 2, 2};
        assertEquals(1, new Solution().numSquarefulPerms(nums));
    }
}