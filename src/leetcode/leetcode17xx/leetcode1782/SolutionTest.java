package leetcode.leetcode17xx.leetcode1782;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void test1() {
        int n = 4;
        int[][] edges = {{1, 2}, {2, 4}, {1, 3}, {2, 3}, {2, 1}};
        int[] queries = {2, 3};
        int[] expected = {6, 5};
        assertArrayEquals(expected, new Solution().countPairs(n, edges, queries));
    }

    @Test
    void test2() {
        int n = 5;
        int[][] edges = {{1, 5}, {1, 5}, {3, 4}, {2, 5}, {1, 3}, {5, 1}, {2, 3}, {2, 5}};
        int[] queries = {1, 2, 3, 4, 5};
        int[] expected = {10, 10, 9, 8, 6};
        assertArrayEquals(expected, new Solution().countPairs(n, edges, queries));
    }
}