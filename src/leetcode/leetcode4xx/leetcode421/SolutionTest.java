package leetcode.leetcode4xx.leetcode421;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {3, 10, 5, 25, 2, 8};
        assertEquals(28, new Solution().findMaximumXOR(nums));
    }
}