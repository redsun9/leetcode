package leetcode.leetcode29xx.leetcode2970;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void incremovableSubarrayCount() {
        Solution solution = new Solution();
        assertEquals(7, solution.incremovableSubarrayCount(new int[]{6, 5, 7, 8}));
    }
}