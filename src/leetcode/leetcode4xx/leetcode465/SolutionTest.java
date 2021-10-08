package leetcode.leetcode4xx.leetcode465;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        Solution solution = new Solution();
        int[][] edges = {{0, 1, 10}, {2, 0, 5}};
        assertEquals(2, solution.balanceGraph(edges));
    }

    @Test
    void test2() {
        Solution solution = new Solution();
        int[][] edges = {{0, 1, 10}, {1, 0, 1}, {1, 2, 5}, {2, 0, 5}};
        assertEquals(1, solution.balanceGraph(edges));
    }
}