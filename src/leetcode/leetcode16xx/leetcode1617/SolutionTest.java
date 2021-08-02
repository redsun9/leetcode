package leetcode.leetcode16xx.leetcode1617;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] edges = {{1, 2}, {2, 3}, {2, 4}};
        int[] expected = {3, 4, 0};
        assertArrayEquals(expected, new Solution().countSubgraphsForEachDiameter(edges.length + 1, edges));
    }

    @Test
    void test2() {
        int[][] edges = {{1, 2}};
        int[] expected = {1};
        assertArrayEquals(expected, new Solution().countSubgraphsForEachDiameter(edges.length + 1, edges));
    }

    @Test
    void test3() {
        int[][] edges = {{1, 2}, {2, 3}};
        int[] expected = {2, 1};
        assertArrayEquals(expected, new Solution().countSubgraphsForEachDiameter(edges.length + 1, edges));
    }
}