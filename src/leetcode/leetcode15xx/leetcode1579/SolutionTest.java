package leetcode.leetcode15xx.leetcode1579;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] edges = {{3, 1, 2}, {3, 2, 3}, {1, 1, 3}, {1, 2, 4}, {1, 1, 2}, {2, 3, 4}};
        assertEquals(2, new Solution().maxNumEdgesToRemove(4, edges));
    }

    @Test
    void test2() {
        int[][] edges = {{3, 1, 2}, {3, 2, 3}, {1, 1, 4}, {2, 1, 4}};
        assertEquals(0, new Solution().maxNumEdgesToRemove(4, edges));
    }

    @Test
    void test3() {
        int[][] edges = {{3, 2, 3}, {1, 1, 2}, {2, 3, 4}};
        assertEquals(-1, new Solution().maxNumEdgesToRemove(4, edges));
    }

}