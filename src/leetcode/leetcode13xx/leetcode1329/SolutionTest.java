package leetcode.leetcode13xx.leetcode1329;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] mat = {{3, 9}, {2, 4}, {1, 2}, {9, 8}, {7, 3}};
        int[][] actual = new Solution2().diagonalSort(mat);
        int[][] expected = {{3, 9}, {2, 4}, {1, 2}, {3, 8}, {7, 9}};
        assertArrayEquals(expected, actual);
    }
}