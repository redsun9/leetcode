package leetcode.leetcode5xx.leetcode564;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals("121", new Solution().nearestPalindromic("123"));
    }

    @Test
    void test2() {
        assertEquals("0", new Solution().nearestPalindromic("1"));
    }

    @Test
    void test3() {
        assertEquals("99", new Solution().nearestPalindromic("100"));
    }

    @Test
    void test4() {
        assertEquals("101", new Solution().nearestPalindromic("99"));
    }

    @Test
    void test5() {
        assertEquals("19991", new Solution().nearestPalindromic("19945"));
    }
}