package leetcode.leetcode38xx.leetcode3814;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        Solution solution = new Solution();
        int[] costs = {5, 4};
        int[] capacity = {5, 7};
        int budget = 6;
        int expected = 7;
        int actual = solution.maxCapacity(costs, capacity, budget);
        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        Solution solution = new Solution();
        int[] costs = {1, 7, 3};
        int[] capacity = {7, 3, 5};
        int budget = 13;
        int expected = 12;
        int actual = solution.maxCapacity(costs, capacity, budget);
        assertEquals(expected, actual);
    }

    @Test
    void test3() {
        Solution solution = new Solution();
        int[] costs = {4, 8, 5, 3};
        int[] capacity = {1, 5, 2, 7};
        int budget = 8;
        int expected = 8;
        int actual = solution.maxCapacity(costs, capacity, budget);
        assertEquals(expected, actual);
    }
}