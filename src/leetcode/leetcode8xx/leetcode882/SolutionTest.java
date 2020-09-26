package leetcode.leetcode8xx.leetcode882;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] edges = {{0, 1, 10}, {0, 2, 1}, {1, 2, 2}};
        assertEquals(13, new Solution().reachableNodes(edges, 6, 3));
    }

    @Test
    void test2() {
        int[][] edges = {{0, 1, 4}, {1, 2, 6}, {0, 2, 8}, {1, 3, 1}};
        assertEquals(23, new Solution().reachableNodes(edges, 10, 4));
    }
}