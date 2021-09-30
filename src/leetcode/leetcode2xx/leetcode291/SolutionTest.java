package leetcode.leetcode2xx.leetcode291;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("SpellCheckingInspection")
class SolutionTest {

    @Test
    void test1() {
        String pattern = "abab";
        String str = "redblueredblue";
        assertTrue(new Solution().wordPatternMatch(pattern, str));
    }

    @Test
    void test2() {
        String pattern = "aaaa";
        String str = "asdasdasdasd";
        assertTrue(new Solution().wordPatternMatch(pattern, str));
    }

    @Test
    void test3() {
        String pattern = "aabb";
        String str = "xyzabcxzyabc";
        assertFalse(new Solution().wordPatternMatch(pattern, str));
    }
}