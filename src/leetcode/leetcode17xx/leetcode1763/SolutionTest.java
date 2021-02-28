package leetcode.leetcode17xx.leetcode1763;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals("aAa", new Solution().longestNiceSubstring("YazaAay"));
    }

    @Test
    void test2() {
        assertEquals("Bb", new Solution().longestNiceSubstring("Bb"));
    }

    @Test
    void test3() {
        assertEquals("", new Solution().longestNiceSubstring("c"));
    }

    @Test
    void test4() {
        assertEquals("dD", new Solution().longestNiceSubstring("dDzeE"));
    }
}