package leetcode.leetcode6xx.leetcode688;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void knightProbability() {
        Solution solution = new Solution();
        System.out.println(solution.knightProbability(3, 2, 0, 0));
        System.out.println(solution.knightProbability(8, 100, 6, 4));
    }
}