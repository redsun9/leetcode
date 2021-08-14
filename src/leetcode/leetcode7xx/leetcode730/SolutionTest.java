package leetcode.leetcode7xx.leetcode730;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(6, new Solution().countPalindromicSubsequences("bccb"));
    }

    @Test
    void test2() {
        assertEquals(104860361, new Solution().countPalindromicSubsequences("abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba"));
    }
}