package leetcode.leetcode37xx.leetcode3786;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}};
        int[] group = {1, 1, 1};
        long expected = 4;
        assertEquals(expected, new Solution().interactionCosts(n, edges, group));
    }

    @Test
    void test2() {
        int n = 4;
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}};
        int[] group = {1, 1, 4, 4};
        long expected = 3;
        assertEquals(expected, new Solution().interactionCosts(n, edges, group));
    }
}