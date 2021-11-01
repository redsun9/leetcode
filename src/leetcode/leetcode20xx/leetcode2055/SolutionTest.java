package leetcode.leetcode20xx.leetcode2055;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void test1() {
        String s = "**|**|***|";
        int[][] queries = {{2, 5}, {5, 9}};
        int[] expected = {2, 3};
        int[] actual = new Solution().platesBetweenCandles(s, queries);
        assertArrayEquals(expected, actual);
    }

    @Test
    void test2() {
        String s = "***|**|*****|**||**|*";
        int[][] queries = {{1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}};
        int[] expected = {9, 0, 0, 0, 0};
        int[] actual = new Solution().platesBetweenCandles(s, queries);
        assertArrayEquals(expected, actual);
    }
}