package leetcode.leetcode22xx.leetcode2232;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String expression = "247+38";
        String expected = "2(47+38)";
        assertEquals(expected, new Solution().minimizeResult(expression));
    }

    @Test
    void test2() {
        String expression = "12+34";
        String expected = "1(2+3)4";
        assertEquals(expected, new Solution().minimizeResult(expression));
    }

    @Test
    void test3() {
        String expression = "999+999";
        String expected = "(999+999)";
        assertEquals(expected, new Solution().minimizeResult(expression));
    }
}