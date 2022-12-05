package leetcode.leetcode24xx.leetcode2484;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void test1() {
        assertEquals(2, new Solution().countPalindromes("103301"));
    }

    @Test
    void test2() {
        assertEquals(21, new Solution().countPalindromes("0000000"));
    }

    @Test
    void test3() {
        assertEquals(2, new Solution().countPalindromes("9999900000"));
    }
}