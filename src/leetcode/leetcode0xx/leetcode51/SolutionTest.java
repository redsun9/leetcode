package leetcode.leetcode0xx.leetcode51;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void testFast() {
        Solution solution = new Solution();
        int[] expected = {1, 1, 0, 0, 2, 10, 4, 40, 92, 352, 724};
        for (int i = 0; i < expected.length; i++) assertEquals(expected[i], solution.solveNQueens(i).size());
    }

    @Test
    @Disabled
    void testFull() {
        Solution solution = new Solution();
        int[] expected = {1, 1, 0, 0, 2, 10, 4, 40, 92, 352, 724, 2680, 14200, 73712, 365596, 2279184, 14772512, 95815104};
        for (int i = 0; i < expected.length; i++) assertEquals(expected[i], solution.solveNQueens(i).size());
    }
}