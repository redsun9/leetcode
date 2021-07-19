package leetcode.leetcode19xx.leetcode1938;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] parents = {-1, 0, 1, 1};
        int[][] queries = {{0, 2}, {3, 2}, {2, 5}};
        int[] expected = {2, 3, 7};
        assertArrayEquals(expected, new Solution().maxGeneticDifference(parents, queries));
    }

    @Test
    void test2() {
        int[] parents = {3, 7, -1, 2, 0, 7, 0, 2};
        int[][] queries = {{4, 6}, {1, 15}, {0, 5}};
        int[] expected = {6, 14, 7};
        assertArrayEquals(expected, new Solution().maxGeneticDifference(parents, queries));
    }
}