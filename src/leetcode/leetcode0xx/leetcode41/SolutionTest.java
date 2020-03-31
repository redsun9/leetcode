package leetcode.leetcode0xx.leetcode41;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void firstMissingPositive() {
        Solution solution = new Solution();
        assertEquals(3, solution.firstMissingPositive(new int[]{1, 2, 0}));
        assertEquals(2, solution.firstMissingPositive(new int[]{3, 4, -1, 1}));
        assertEquals(1, solution.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
        assertEquals(5, solution.firstMissingPositive(new int[]{2, 1, 4, 3}));
    }
}