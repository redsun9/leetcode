package leetcode.leetcode10xx.leetcode1004;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] a = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        assertEquals(6, new Solution().longestOnes(a, 2));
    }
}