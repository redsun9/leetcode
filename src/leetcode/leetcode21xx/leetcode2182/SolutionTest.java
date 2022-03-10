package leetcode.leetcode21xx.leetcode2182;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String s = "cczazcc";
        int repeatLimit = 3;
        String expected = "zzcccac";
        assertEquals(expected, new Solution().repeatLimitedString(s, repeatLimit));
    }

    @Test
    void test2() {
        String s = "aababab";
        int repeatLimit = 2;
        String expected = "bbabaa";
        assertEquals(expected, new Solution().repeatLimitedString(s, repeatLimit));
    }
}