package leetcode.leetcode20xx.leetcode2065;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] values = {0, 32, 10, 43};
        int[][] edges = {{0, 1, 10}, {1, 2, 15}, {0, 3, 10}};
        int maxTime = 49;
        int expected = 75;
        assertEquals(expected, new Solution().maximalPathQuality(values, edges, maxTime));
    }

    @Test
    void test2() {
        int[] values = {5, 10, 15, 20};
        int[][] edges = {{0, 1, 10}, {1, 2, 10}, {0, 3, 10}};
        int maxTime = 30;
        int expected = 25;
        assertEquals(expected, new Solution().maximalPathQuality(values, edges, maxTime));
    }

    @Test
    void test3() {
        int[] values = {1, 2, 3, 4};
        int[][] edges = {{0, 1, 10}, {1, 2, 11}, {2, 3, 12}, {1, 3, 13}};
        int maxTime = 50, expected = 7;
        assertEquals(expected, new Solution().maximalPathQuality(values, edges, maxTime));
    }

    @Test
    void test4() {
        int[] values = {0, 1, 2};
        int[][] edges = {{1, 2, 10}};
        int maxTime = 10, expected = 0;
        assertEquals(expected, new Solution().maximalPathQuality(values, edges, maxTime));
    }
}