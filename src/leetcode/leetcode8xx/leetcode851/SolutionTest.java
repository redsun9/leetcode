package leetcode.leetcode8xx.leetcode851;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] richer = {{1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}};
        int[] quiet = {3, 2, 5, 4, 6, 1, 7, 0};
        int[] expected = {5, 5, 2, 5, 4, 5, 6, 7};
        assertArrayEquals(expected, new Solution().loudAndRich(richer, quiet));
    }
}