package leetcode.leetcode5xx.leetcode587;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] trees = {{0, 2}, {0, 1}, {0, 0}, {1, 0}, {2, 0}, {1, 1}};
        int[][] actual = new Solution().outerTrees(trees);
        assertEquals(trees.length, actual.length);
    }
}