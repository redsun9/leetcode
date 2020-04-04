package leetcode.leetcode14xx.leetcode1402;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void maxSatisfaction() {
        Solution solution = new Solution();
        assertEquals(14, solution.maxSatisfaction(new int[]{-1, -8, 0, 5, -9}));
        assertEquals(20, solution.maxSatisfaction(new int[]{4, 3, 2}));
        assertEquals(0, solution.maxSatisfaction(new int[]{-1, -4, -5}));
        assertEquals(35, solution.maxSatisfaction(new int[]{-2, 5, -1, 0, 3, -3}));
    }
}