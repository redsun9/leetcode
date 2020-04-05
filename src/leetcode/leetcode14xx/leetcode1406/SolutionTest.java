package leetcode.leetcode14xx.leetcode1406;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void stoneGameIII() {
        Solution solution = new Solution();
        assertEquals("Bob", solution.stoneGameIII(new int[]{1, 2, 3, 7}));
        assertEquals("Alice", solution.stoneGameIII(new int[]{1, 2, 3, -9}));
        assertEquals("Tie", solution.stoneGameIII(new int[]{1, 2, 3, 6}));
        assertEquals("Alice", solution.stoneGameIII(new int[]{1, 2, 3, -1, -2, -3, 7}));
        assertEquals("Tie", solution.stoneGameIII(new int[]{-1, -2, -3}));
    }
}