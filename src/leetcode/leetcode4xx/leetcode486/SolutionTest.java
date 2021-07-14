package leetcode.leetcode4xx.leetcode486;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        int[] nums = {1, 5, 2};
        assertFalse(new Solution().PredictTheWinner(nums));
    }

    @Test
    void test2() {
        int[] nums = {1, 5, 233, 7};
        assertTrue(new Solution().PredictTheWinner(nums));
    }
}