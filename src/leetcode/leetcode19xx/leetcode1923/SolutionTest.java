package leetcode.leetcode19xx.leetcode1923;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] paths = {{0, 1, 2, 3, 4}, {2, 3, 4}, {4, 0, 1, 2, 3}};
        assertEquals(2, new Solution().longestCommonSubpath(5, paths));
    }

    @Test
    void test2() {
        int[][] paths = {{0}, {1}, {2}};
        assertEquals(0, new Solution().longestCommonSubpath(3, paths));
    }

    @Test
    void test3() {
        int[][] paths = {{0, 1, 2, 3, 4}, {4, 3, 2, 1, 0}};
        assertEquals(1, new Solution().longestCommonSubpath(5, paths));
    }
}