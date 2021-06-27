package leetcode.leetcode19xx.leetcode1910;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String s = "daabcbaabcbc", part = "abc", expected = "dab";
        assertEquals(expected, new Solution().removeOccurrences(s, part));
    }

    @Test
    void test2() {
        String s = "axxxxyyyyb", part = "xy", expected = "ab";
        assertEquals(expected, new Solution().removeOccurrences(s, part));
    }

    @Test
    void test3() {
        String s = "wvwwwwswxwwwwsdwxweeohapwwzwuwajrnogb", part = "w", expected = "vsxsdxeeohapzuajrnogb";
        assertEquals(expected, new Solution().removeOccurrences(s, part));
    }

    @Test
    void test4() {
        String s = "acacacacacbbb", part = "acacb", expected = "acb";
        assertEquals(expected, new Solution().removeOccurrences(s, part));
    }
}