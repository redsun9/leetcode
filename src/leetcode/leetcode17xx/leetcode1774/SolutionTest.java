package leetcode.leetcode17xx.leetcode1774;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] baseCosts = {1, 7};
        int[] toppingCosts = {3, 4};
        assertEquals(10, new Solution().closestCost(baseCosts, toppingCosts, 10));
    }

    @Test
    void test2() {
        int[] baseCosts = {2, 3};
        int[] toppingCosts = {4, 5, 100};
        assertEquals(17, new Solution().closestCost(baseCosts, toppingCosts, 18));
    }

    @Test
    void test3() {
        int[] baseCosts = {3, 10};
        int[] toppingCosts = {2, 5};
        assertEquals(8, new Solution().closestCost(baseCosts, toppingCosts, 9));
    }

    @Test
    void test4() {
        int[] baseCosts = {10};
        int[] toppingCosts = {1};
        assertEquals(10, new Solution().closestCost(baseCosts, toppingCosts, 1));
    }

    @Test
    void test5() {
        int[] baseCosts = {9, 10, 1};
        int[] toppingCosts = {1, 8, 8, 1, 1, 8};
        assertEquals(7, new Solution().closestCost(baseCosts, toppingCosts, 8));
    }
}