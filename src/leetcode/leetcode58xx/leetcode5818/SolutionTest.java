package leetcode.leetcode58xx.leetcode5818;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] arrays = {{1, 3, 4}, {1, 4, 7, 9}};
        List<Integer> expected = List.of(1, 4);
        assertEquals(expected, new Solution().longestCommomSubsequence(arrays));
    }

    @Test
    void test2() {
        int[][] arrays = {{2, 3, 6, 8}, {1, 2, 3, 5, 6, 7, 10}, {2, 3, 4, 6, 9}};
        List<Integer> expected = List.of(2, 3, 6);
        assertEquals(expected, new Solution().longestCommomSubsequence(arrays));
    }

    @Test
    void test3() {
        int[][] arrays = {{1, 2, 3, 4, 5}, {6, 7, 8}};
        List<Integer> expected = List.of();
        assertEquals(expected, new Solution().longestCommomSubsequence(arrays));
    }
}