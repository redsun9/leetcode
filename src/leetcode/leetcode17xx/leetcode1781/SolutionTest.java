package leetcode.leetcode17xx.leetcode1781;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(5, new Solution().beautySum("aabcb"));
    }

    @Test
    void test2() {
        assertEquals(17, new Solution().beautySum("aabcbaa"));
    }
}