package leetcode.leetcode9xx.leetcode940;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(7, new Solution().distinctSubseqII("abc"));
    }

    @Test
    void test2() {
        assertEquals(6, new Solution().distinctSubseqII("aba"));
    }

    @Test
    void test3() {
        assertEquals(3, new Solution().distinctSubseqII("aaa"));
    }
}