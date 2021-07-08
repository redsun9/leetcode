package leetcode.leetcode17xx.leetcode1776;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] cars = {{1, 2}, {2, 1}, {4, 3}, {7, 2}};
        double[] expected = {1.00000, -1.00000, 3.00000, -1.00000};
        assertArrayEquals(expected, new Solution().getCollisionTimes(cars), 1e-6);
    }

    @Test
    void test2() {
        int[][] cars = {{3, 4}, {5, 4}, {6, 3}, {9, 1}};
        double[] expected = {2.00000, 1.00000, 1.50000, -1.00000};
        assertArrayEquals(expected, new Solution().getCollisionTimes(cars), 1e-6);
    }
}