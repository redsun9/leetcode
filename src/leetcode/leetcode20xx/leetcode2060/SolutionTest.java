package leetcode.leetcode20xx.leetcode2060;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("SpellCheckingInspection")
class SolutionTest {

    @Test
    void test1() {
        String s1 = "internationalization", s2 = "i18n";
        assertTrue(new Solution().possiblyEquals(s1, s2));
        assertTrue(new Solution().possiblyEquals(s2, s1));
    }

    @Test
    void test2() {
        String s1 = "l123e", s2 = "44";
        assertTrue(new Solution().possiblyEquals(s1, s2));
        assertTrue(new Solution().possiblyEquals(s2, s1));
    }

    @Test
    void test3() {
        String s1 = "a5b", s2 = "c5b";
        assertFalse(new Solution().possiblyEquals(s1, s2));
        assertFalse(new Solution().possiblyEquals(s2, s1));
    }

    @Test
    void test4() {
        String s1 = "112s", s2 = "g841";
        assertTrue(new Solution().possiblyEquals(s1, s2));
        assertTrue(new Solution().possiblyEquals(s2, s1));
    }

    @Test
    void test5() {
        String s1 = "ab", s2 = "a2";
        assertFalse(new Solution().possiblyEquals(s1, s2));
        assertFalse(new Solution().possiblyEquals(s2, s1));
    }

    @Test
    void test6() {
        String s1 = "abcd", s2 = "a2d";
        assertTrue(new Solution().possiblyEquals(s1, s2));
        assertTrue(new Solution().possiblyEquals(s2, s1));
    }

    @Test
    void test7() {
        String s1 = "x94", s2 = "x14";
        assertFalse(new Solution().possiblyEquals(s1, s2));
        assertFalse(new Solution().possiblyEquals(s2, s1));
    }
}