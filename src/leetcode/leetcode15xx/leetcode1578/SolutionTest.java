package leetcode.leetcode15xx.leetcode1578;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String s = "abaac";
        int[] cost = {1, 2, 3, 4, 5};
        assertEquals(3, new Solution().minCost(s, cost));
    }

    @Test
    void test2() {
        String s = "abc";
        int[] cost = {1, 2, 3};
        assertEquals(0, new Solution().minCost(s, cost));
    }

    @Test
    void test3() {
        String s = "aabaa";
        int[] cost = {1, 2, 3, 4, 1};
        assertEquals(2, new Solution().minCost(s, cost));
    }
}