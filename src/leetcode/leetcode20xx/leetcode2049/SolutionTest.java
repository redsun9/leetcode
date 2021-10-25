package leetcode.leetcode20xx.leetcode2049;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] parents = {-1, 2, 0, 2, 0};
        assertEquals(3, new Solution().countHighestScoreNodes(parents));
    }

    @Test
    void test2() {
        int[] parents = {-1, 2, 0};
        assertEquals(2, new Solution().countHighestScoreNodes(parents));
    }
}