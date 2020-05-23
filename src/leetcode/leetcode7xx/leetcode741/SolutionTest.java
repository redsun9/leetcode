package leetcode.leetcode7xx.leetcode741;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] mat = {
                {0, 1, -1},
                {1, 0, -1},
                {1, 1, 1}
        };
        assertEquals(5, new Solution().cherryPickup(mat));
    }

    @Test
    void test2() {
        int[][] mat = {
                {1, -1, 1, -1, 1, 1, 1, 1, 1, -1},
                {-1, 1, 1, -1, -1, 1, 1, 1, 1, 1},
                {1, 1, 1, -1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {-1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, -1, 1, 1, 1, 1, -1, 1, 1, 1},
                {1, 1, 1, -1, 1, 1, -1, 1, 1, 1},
                {1, -1, 1, -1, -1, 1, 1, 1, 1, 1},
                {1, 1, -1, -1, 1, 1, 1, -1, 1, -1},
                {1, 1, -1, 1, 1, 1, 1, 1, 1, 1}
        };
        assertEquals(0, new Solution().cherryPickup(mat));
    }
}