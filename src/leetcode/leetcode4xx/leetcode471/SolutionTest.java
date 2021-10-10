package leetcode.leetcode4xx.leetcode471;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        String s = "abbbabbbcabbbabbbc";
        String expected = "2[2[abbb]c]";
        assertEquals(expected, new Solution().encode(s));
    }

    @Test
    void test2() {
        String s = "aa";
        String expected = "aa";
        assertEquals(expected, new Solution().encode(s));
    }

    @Test
    void test3() {
        String s = "aaaaa";
        String expected = "5[a]";
        assertEquals(expected, new Solution().encode(s));
    }

    @Test
    void test4() {
        String s = "aaaaaaaaaa";
        Set<String> expected = Set.of("10[a]", "a9[a]", "9[a]a");
        assertTrue(expected.contains(new Solution().encode(s)));
    }

    @Test
    void test5() {
        String s = "aabcaabcd";
        String expected = "2[aabc]d";
        assertEquals(expected, new Solution().encode(s));
    }
}