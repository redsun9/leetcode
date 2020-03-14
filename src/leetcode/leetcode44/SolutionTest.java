package leetcode.leetcode44;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("SpellCheckingInspection")
class SolutionTest {

    @Test
    void isMatch() {
        Solution solution = new Solution();
        assertFalse(solution.isMatch("aa", "a"));
        assertTrue(solution.isMatch("aa", "*"));
        assertFalse(solution.isMatch("cb", "?a"));
        assertTrue(solution.isMatch("adceb", "*a*b"));
        assertFalse(solution.isMatch("acdcb", "a*c?b"));
        assertFalse(solution.isMatch("aaaaa", "a*c*a"));
        assertTrue(solution.isMatch("bbabab", "**?a*"));
    }
}