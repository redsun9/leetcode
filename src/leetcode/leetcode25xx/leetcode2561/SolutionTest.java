package leetcode.leetcode25xx.leetcode2561;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] basket1 = {4, 2, 2, 2}, basket2 = {1, 4, 1, 2};
        assertEquals(1, new Solution().minCost(basket1, basket2));
    }

    @Test
    void test2() {
        int[] basket1 = {2, 3, 4, 1}, basket2 = {3, 2, 5, 1};
        assertEquals(-1, new Solution().minCost(basket1, basket2));
    }
}