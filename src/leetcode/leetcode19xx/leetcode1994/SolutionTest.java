package leetcode.leetcode19xx.leetcode1994;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {1, 2, 3, 4};
        assertEquals(6, new Solution().numberOfGoodSubsets(nums));
    }
}