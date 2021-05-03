package leetcode.leetcode17xx.leetcode1754;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals("cbcabaaaaa", new Solution().largestMerge("cabaa", "bcaaa"));
    }

    @Test
    void test2() {
        assertEquals("abdcabcabcaba", new Solution().largestMerge("abcabc", "abdcaba"));
    }
}