package leetcode.leetcode18xx.leetcode1880;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test() {
        assertTrue(new Solution().isSumEqual("acb", "cba", "cdb"));
        assertFalse(new Solution().isSumEqual("aaa", "a", "aab"));
        assertTrue(new Solution().isSumEqual("aaa", "a", "aaaa"));
    }
}