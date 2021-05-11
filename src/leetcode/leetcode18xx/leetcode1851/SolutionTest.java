package leetcode.leetcode18xx.leetcode1851;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] intervals = {{1, 4}, {2, 4}, {3, 6}, {4, 4}};
        int[] queries = {2, 3, 4, 5};
        int[] output = {3, 3, 1, 4};
        assertArrayEquals(output, new Solution().minInterval(intervals, queries));
    }

    @Test
    void test2() {
        int[][] intervals = {{2, 3}, {2, 5}, {1, 8}, {20, 25}};
        int[] queries = {2, 19, 5, 22};
        int[] output = {2, -1, 4, 6};
        assertArrayEquals(output, new Solution().minInterval(intervals, queries));
    }
}