package leetcode.leetcode35xx.leetcode3518;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String s = "abba";
        int k = 2;
        String expected = "baab";
        assertEquals(expected, new Solution().smallestPalindrome(s, k));
    }

    @Test
    void test2() {
        String s = "aa";
        int k = 2;
        String expected = "";
        assertEquals(expected, new Solution().smallestPalindrome(s, k));
    }

    @Test
    void test3() {
        String s = "bacab";
        int k = 1;
        String expected = "abcba";
        assertEquals(expected, new Solution().smallestPalindrome(s, k));
    }
}