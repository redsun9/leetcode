package leetcode.leetcode3xx.leetcode395;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(3, new Solution().longestSubstring("aaabb", 3));
        assertEquals(5, new Solution().longestSubstring("ababbc", 2));
    }
}