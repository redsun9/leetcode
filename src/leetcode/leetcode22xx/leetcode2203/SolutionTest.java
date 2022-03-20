package leetcode.leetcode22xx.leetcode2203;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int n = 6, src1 = 0, src2 = 1, dest = 5;
        int[][] edges = {{0, 2, 2}, {0, 5, 6}, {1, 0, 3}, {1, 4, 5}, {2, 1, 1}, {2, 3, 3}, {2, 3, 4}, {3, 4, 2}, {4, 5, 1}};
        int expected = 9;
        assertEquals(expected, new Solution().minimumWeight(n, edges, src1, src2, dest));
    }

    @Test
    void test2() {
        int n = 3, src1 = 0, src2 = 1, dest = 2;
        int[][] edges = {{0, 1, 1}, {2, 1, 1}};
        int expected = -1;
        assertEquals(expected, new Solution().minimumWeight(n, edges, src1, src2, dest));
    }
}