package leetcode.leetcode5xx.leetcode505;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] start = {0, 4};
        int[] dest = {4, 4};
        int[][] mat = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };
        assertEquals(12, new Solution().shortestDistance(mat, start, dest));
    }

    @Test
    void test2() {
        int[] start = {0, 4};
        int[] dest = {0, 0};
        int[][] mat = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };
        assertEquals(6, new Solution().shortestDistance(mat, start, dest));
    }

    @Test
    void test3() {
        int[] start = {0, 0};
        int[] dest = {8, 6};
        int[][] mat = {
                {0, 0, 0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0}
        };
        assertEquals(26, new Solution().shortestDistance(mat, start, dest));
    }
}


