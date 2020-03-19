package leetcode.leetcode312;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void testMaxCoins() {
        Solution solution = new Solution();
        assertEquals(167, solution.maxCoins(new int[]{3, 1, 5, 8}));
    }
}