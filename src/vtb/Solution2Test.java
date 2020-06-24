package vtb;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution2Test {

    @Test
    void test1() {
        assertEquals(3, Solution2.longestSubstring("ababa"));
    }

    @Test
    void test2() {
        assertEquals(6, Solution2.longestSubstring("aaabaaa"));
    }

    @Test
    void test3() {
        assertEquals(6, Solution2.longestSubstring("aaaaaa"));
    }

    @Test
    void test4() {
        assertEquals(3, Solution2.longestSubstring("aaabbb"));
    }

    @Test
    void test5() {
        assertEquals(1, Solution2.longestSubstring("abcd"));
    }

    @Test
    void test6() {
        assertEquals(8, Solution2.longestSubstring("aabbbaaabaaaa"));
    }
}