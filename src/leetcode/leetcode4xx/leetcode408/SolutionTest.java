package leetcode.leetcode4xx.leetcode408;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        assertTrue(new Solution().validWordAbbreviation("internationalization", "i12iz4n"));
    }

    @Test
    void test2() {
        assertFalse(new Solution().validWordAbbreviation("apple", "a2e"));
    }
}