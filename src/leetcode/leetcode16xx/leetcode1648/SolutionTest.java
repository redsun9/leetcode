package leetcode.leetcode16xx.leetcode1648;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] inventory = {2, 5};
        assertEquals(14, new Solution().maxProfit(inventory, 4));
    }

    @Test
    void test2() {
        int[] inventory = {3, 5};
        assertEquals(19, new Solution().maxProfit(inventory, 6));
    }

    @Test
    void test3() {
        int[] inventory = {2, 8, 4, 10, 6};
        assertEquals(110, new Solution().maxProfit(inventory, 20));
    }

    @Test
    void test4() {
        int[] inventory = {1000000000};
        assertEquals(21, new Solution().maxProfit(inventory, 1000000000));
    }
}