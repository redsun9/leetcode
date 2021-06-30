package leetcode.leetcode7xx.leetcode738;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(9, new Solution().monotoneIncreasingDigits(10));
    }

    @Test
    void test2() {
        assertEquals(1234, new Solution().monotoneIncreasingDigits(1234));
    }

    @Test
    void test3() {
        assertEquals(299, new Solution().monotoneIncreasingDigits(332));
    }
}