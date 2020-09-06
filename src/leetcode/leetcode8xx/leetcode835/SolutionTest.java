package leetcode.leetcode8xx.leetcode835;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] a = {
                {1, 1, 0},
                {0, 1, 0},
                {0, 1, 0}
        };
        int[][] b = {
                {0, 0, 0},
                {0, 1, 1},
                {0, 0, 1}
        };
        assertEquals(3, new Solution().largestOverlap(a, b));
    }
}