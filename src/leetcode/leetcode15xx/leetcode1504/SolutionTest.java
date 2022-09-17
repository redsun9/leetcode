package leetcode.leetcode15xx.leetcode1504;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] mat = {{1, 0, 1}, {1, 1, 0}, {1, 1, 0}};
        assertEquals(13, new Solution().numSubmat(mat));
    }

    @Test
    void test2() {
        int[][] mat = {{0, 1, 1, 0}, {0, 1, 1, 1}, {1, 1, 1, 0}};
        assertEquals(24, new Solution().numSubmat(mat));
    }
}