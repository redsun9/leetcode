package leetcode.leetcode17xx.leetcode1771;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String word1 = "cacb", word2 = "cbba";
        assertEquals(5, new Solution().longestPalindrome(word1, word2));
    }

    @Test
    void test2() {
        String word1 = "ab", word2 = "ab";
        assertEquals(3, new Solution().longestPalindrome(word1, word2));
    }

    @Test
    void test3() {
        String word1 = "aa", word2 = "bb";
        assertEquals(0, new Solution().longestPalindrome(word1, word2));
    }
}