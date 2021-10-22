package leetcode.leetcode20xx.leetcode2039;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] edges = {{0, 1}, {1, 2}};
        int[] patience = {0, 2, 1};
        assertEquals(8, new Solution().networkBecomesIdle(edges, patience));
    }

    @Test
    void test2() {
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}};
        int[] patience = {0, 10, 10};
        assertEquals(3, new Solution().networkBecomesIdle(edges, patience));
    }
}