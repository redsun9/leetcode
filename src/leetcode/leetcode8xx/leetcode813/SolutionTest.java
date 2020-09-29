package leetcode.leetcode8xx.leetcode813;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] a = {9, 1, 2, 3, 9};
        assertEquals(20, new Solution().largestSumOfAverages(a, 3));
    }
}