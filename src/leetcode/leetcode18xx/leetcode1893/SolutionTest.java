package leetcode.leetcode18xx.leetcode1893;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        int[][] ranges = {{1, 2}, {3, 4}, {5, 6}};
        int left = 2, right = 5;
        assertTrue(new Solution().isCovered(ranges, left, right));
    }

    @Test
    void test2() {
        int[][] ranges = {{1, 10}, {10, 20}};
        int left = 21, right = 21;
        assertFalse(new Solution().isCovered(ranges, left, right));
    }
}