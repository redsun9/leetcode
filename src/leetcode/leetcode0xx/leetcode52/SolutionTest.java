package leetcode.leetcode0xx.leetcode52;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void solveNQueens() {
        Solution solution = new Solution();
        int[] expected = {1, 1, 0, 0, 2, 10, 4, 40, 92, 352, 724, 2680, 14200, 73712, 365596, 2279184, 14772512, 95815104};
        for (int i = 0; i <= 10; i++) {
            long start = System.nanoTime();
            assertEquals(expected[i], solution.totalNQueens(i));
            long end = System.nanoTime();
            System.out.println(i + " - " + (end - start) / 1_000_000);
        }

    }
}