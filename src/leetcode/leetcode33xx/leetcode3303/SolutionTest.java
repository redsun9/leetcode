package leetcode.leetcode33xx.leetcode3303;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String s = "abcdefg", pattern = "bcdffg";
        assertEquals(1, new Solution().minStartingIndex(s, pattern));
    }

    @Test
    void test2() {
        String s = "ababbababa", pattern = "bacaba";
        assertEquals(4, new Solution().minStartingIndex(s, pattern));
    }

    @Test
    void test3() {
        String s = "abcd", pattern = "dba";
        assertEquals(-1, new Solution().minStartingIndex(s, pattern));
    }

    @Test
    void test4() {
        String s = "dde", pattern = "d";
        assertEquals(0, new Solution().minStartingIndex(s, pattern));
    }

    @Test
    void test5() {
        String s = "ooononooonnoo", pattern = "onnooo";
        assertEquals(-1, new Solution().minStartingIndex(s, pattern));
    }
}