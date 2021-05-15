package leetcode.leetcode9xx.leetcode913;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] graph = {{2, 5}, {3}, {0, 4, 5}, {1, 4, 5}, {2, 3}, {0, 2, 3}};
        assertEquals(0, new Solution().catMouseGame(graph));
    }

    @Test
    void test2() {
        int[][] graph = {{1, 3}, {0}, {3}, {0, 2}};
        assertEquals(1, new Solution().catMouseGame(graph));
    }
}