package leetcode.leetcode17xx.leetcode1792;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] classes = {{1, 2}, {3, 5}, {2, 2}};
        assertEquals(0.78333, new Solution().maxAverageRatio(classes, 2), 1e-5);
    }

    @Test
    void test2() {
        int[][] classes = {{2, 4}, {3, 9}, {4, 5}, {2, 10}};
        assertEquals(0.53485, new Solution().maxAverageRatio(classes, 4), 1e-5);
    }
}