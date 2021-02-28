package leetcode.leetcode17xx.leetcode1736;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals("23:50", new Solution().maximumTime("2?:?0"));
    }

    @Test
    void test2() {
        assertEquals("09:39", new Solution().maximumTime("0?:3?"));
    }

    @Test
    void test3() {
        assertEquals("19:22", new Solution().maximumTime("1?:22"));
    }
}