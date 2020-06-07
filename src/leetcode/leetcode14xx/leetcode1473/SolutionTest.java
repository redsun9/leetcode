package leetcode.leetcode14xx.leetcode1473;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] houses = {0, 0, 0, 0, 0};
        int[][] cost = {{1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}};
        int m = 5, n = 2, target = 3;
        assertEquals(9, new Solution().minCost(houses, cost, m, n, target));
    }

    @Test
    void test2() {
        int[] houses = {0, 2, 1, 2, 0};
        int[][] cost = {{1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}};
        int m = 5, n = 2, target = 3;
        assertEquals(11, new Solution().minCost(houses, cost, m, n, target));
    }

    @Test
    void test3() {
        int[] houses = {0, 0, 0, 0, 0};
        int[][] cost = {{1, 10}, {10, 1}, {1, 10}, {10, 1}, {1, 10}};
        int m = 5, n = 2, target = 5;
        assertEquals(5, new Solution().minCost(houses, cost, m, n, target));
    }

    @Test
    void test4() {
        int[] houses = {3, 1, 2, 3};
        int[][] cost = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        int m = 4, n = 3, target = 3;
        assertEquals(-1, new Solution().minCost(houses, cost, m, n, target));
    }
}