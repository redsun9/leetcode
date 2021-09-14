package leetcode.leetcode6xx.leetcode688;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void knightProbability() {
        Solution solution = new Solution();
        assertEquals(0.0625, solution.knightProbability(3, 2, 0, 0), 1e-8);
        assertEquals(3.8744379E-13, solution.knightProbability(8, 100, 6, 4), 1e-19);
    }
}