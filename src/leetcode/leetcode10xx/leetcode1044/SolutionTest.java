package leetcode.leetcode10xx.leetcode1044;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals("", new Solution().longestDupSubstring("abcd"));
    }

    @Test
    void test2() {
        assertEquals("ana", new Solution().longestDupSubstring("banana"));
    }
}