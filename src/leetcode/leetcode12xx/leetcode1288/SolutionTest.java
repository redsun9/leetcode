package leetcode.leetcode12xx.leetcode1288;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] intervals = {{1, 4}, {3, 6}, {2, 8}};
        assertEquals(2, new Solution().removeCoveredIntervals(intervals));
    }
}