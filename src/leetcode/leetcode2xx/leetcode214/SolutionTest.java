package leetcode.leetcode2xx.leetcode214;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String s = "aacecaaa", expected = "aaacecaaa";
        assertEquals(expected, new Solution().shortestPalindrome(s));
    }

    @Test
    void test2() {
        String s = "abcd", expected = "dcbabcd";
        assertEquals(expected, new Solution().shortestPalindrome(s));
    }
}