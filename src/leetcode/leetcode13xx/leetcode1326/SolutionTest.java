package leetcode.leetcode13xx.leetcode1326;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] ranges = {1, 2, 1, 0, 2, 1, 0, 1};
        assertEquals(3, new Solution().minTaps(7, ranges));
    }
}