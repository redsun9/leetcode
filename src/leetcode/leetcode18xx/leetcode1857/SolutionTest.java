package leetcode.leetcode18xx.leetcode1857;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String colors = "abaca";
        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {3, 4}};
        assertEquals(3, new Solution().largestPathValue(colors, edges));
    }

    @Test
    void test2() {
        String colors = "a";
        int[][] edges = {{0, 0}};
        assertEquals(-1, new Solution().largestPathValue(colors, edges));
    }
}