package leetcode.leetcode17xx.leetcode1751;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] events = {{1, 2, 4}, {3, 4, 3}, {2, 3, 1}};
        int k = 2;
        assertEquals(7, new Solution().maxValue(events, k));
    }

    @Test
    void test2() {
        int[][] events = {{1, 2, 4}, {3, 4, 3}, {2, 3, 10}};
        int k = 2;
        assertEquals(10, new Solution().maxValue(events, k));
    }

    @Test
    void test3() {
        int[][] events = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}, {4, 4, 4}};
        int k = 3;
        assertEquals(9, new Solution().maxValue(events, k));
    }
}