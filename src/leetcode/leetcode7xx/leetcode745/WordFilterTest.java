package leetcode.leetcode7xx.leetcode745;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordFilterTest {

    @Test
    void test1() {
        String[] words = {"apple"};
        WordFilter filter = new WordFilter(words);
        assertEquals(0, filter.f("a", "e"));
        assertEquals(0, filter.f("ap", "e"));
        assertEquals(0, filter.f("app", "pple"));
        assertEquals(0, filter.f("apple", ""));
        assertEquals(0, filter.f("", "apple"));
        assertEquals(-1, filter.f("ae", "le"));
    }

    @Test
    void test2() {
        String[] words = {"apple", "app", "ape", "people"};
        WordFilter filter = new WordFilter(words);
        assertEquals(2, filter.f("a", "e"));
        assertEquals(2, filter.f("ap", ""));
        assertEquals(3, filter.f("", "ple"));
        assertEquals(2, filter.f("a", ""));
        assertEquals(3, filter.f("", "e"));
        assertEquals(-1, filter.f("ae", "le"));
    }
}