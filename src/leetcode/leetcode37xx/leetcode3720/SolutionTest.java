package leetcode.leetcode37xx.leetcode3720;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void lexGreaterPermutation() {
        assertEquals("bca", new Solution().lexGreaterPermutation("abc", "bba"));
        assertEquals("eelt", new Solution().lexGreaterPermutation("leet", "code"));
        assertEquals("", new Solution().lexGreaterPermutation("baba", "bbaa"));
    }
}