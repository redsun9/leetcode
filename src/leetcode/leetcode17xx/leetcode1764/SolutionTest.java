package leetcode.leetcode17xx.leetcode1764;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        int[][] groups = {{1, -1, -1}, {3, -2, 0}};
        int[] nums = {1, -1, 0, 1, -1, -1, 3, -2, 0};
        assertTrue(new Solution().canChoose(groups, nums));
    }

    @Test
    void test2() {
        int[][] groups = {{10, -2}, {1, 2, 3, 4}};
        int[] nums = {1, 2, 3, 4, 10, -2};
        assertFalse(new Solution().canChoose(groups, nums));
    }

    @Test
    void test3() {
        int[][] groups = {{1, 2, 3}, {3, 4}};
        int[] nums = {7, 7, 1, 2, 3, 4, 7, 7};
        assertFalse(new Solution().canChoose(groups, nums));
    }
}