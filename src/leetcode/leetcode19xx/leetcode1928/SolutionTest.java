package leetcode.leetcode19xx.leetcode1928;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int maxTime = 30;
        int[][] edges = {{0, 1, 10}, {1, 2, 10}, {2, 5, 10}, {0, 3, 1}, {3, 4, 10}, {4, 5, 15}};
        int[] passingFees = {5, 1, 2, 20, 20, 3};
        assertEquals(11, new Solution().minCost(maxTime, edges, passingFees));
    }

    @Test
    void test2() {
        int maxTime = 29;
        int[][] edges = {{0, 1, 10}, {1, 2, 10}, {2, 5, 10}, {0, 3, 1}, {3, 4, 10}, {4, 5, 15}};
        int[] passingFees = {5, 1, 2, 20, 20, 3};
        assertEquals(48, new Solution().minCost(maxTime, edges, passingFees));
    }

    @Test
    void test3() {
        int maxTime = 25;
        int[][] edges = {{0, 1, 10}, {1, 2, 10}, {2, 5, 10}, {0, 3, 1}, {3, 4, 10}, {4, 5, 15}};
        int[] passingFees = {5, 1, 2, 20, 20, 3};
        assertEquals(-1, new Solution().minCost(maxTime, edges, passingFees));
    }
}