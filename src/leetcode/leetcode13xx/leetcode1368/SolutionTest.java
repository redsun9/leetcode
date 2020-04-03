package leetcode.leetcode13xx.leetcode1368;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        Solution solution = new Solution();
        assertEquals(3, solution.minCost(new int[][]{{1, 1, 1, 1}, {2, 2, 2, 2}, {1, 1, 1, 1}, {2, 2, 2, 2}}));
    }

    @Test
    void test2() {
        Solution solution = new Solution();
        assertEquals(0, solution.minCost(new int[][]{{1, 1, 3}, {3, 2, 2}, {1, 1, 4}}));
    }

    @Test
    void test3() {
        Solution solution = new Solution();
        assertEquals(1, solution.minCost(new int[][]{{1, 2}, {4, 3}}));
    }

    @Test
    void test4() {
        Solution solution = new Solution();
        assertEquals(3, solution.minCost(new int[][]{{2, 2, 2}, {2, 2, 2}}));
    }

    @Test
    void test5() {
        Solution solution = new Solution();
        assertEquals(0, solution.minCost(new int[][]{{4}}));
    }
}