package leetcode.leetcode8xx.leetcode890;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String[] words = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern = "abb";
        List<String> expected = List.of("mee", "aqq");
        assertEquals(expected, new Solution().findAndReplacePattern(words, pattern));
    }

    @Test
    void test2() {
        String[] words = {"a", "b", "c"};
        String pattern = "a";
        List<String> expected = List.of("a", "b", "c");
        assertEquals(expected, new Solution().findAndReplacePattern(words, pattern));
    }
}