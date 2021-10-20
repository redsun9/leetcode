package leetcode.leetcode20xx.leetcode2045;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int n = 5, time = 3, change = 5;
        int[][] edges = {{1, 2}, {1, 3}, {1, 4}, {3, 4}, {4, 5}};
        assertEquals(13, new Solution().secondMinimum(n, edges, time, change));
    }

    @Test
    void test2() {
        int n = 2, time = 3, change = 2;
        int[][] edges = {{1, 2}};
        assertEquals(11, new Solution().secondMinimum(n, edges, time, change));
    }
}