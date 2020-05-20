package leetcode.leetcode1xx.leetcode166;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals("0.5", new Solution().fractionToDecimal(1, 2));
    }

    @Test
    void test2() {
        assertEquals("2", new Solution().fractionToDecimal(2, 1));
    }

    @Test
    void test3() {
        assertEquals("0.(6)", new Solution().fractionToDecimal(2, 3));
    }

    @Test
    void test4() {
        assertEquals("0.(0588235294117647)", new Solution().fractionToDecimal(1, 17));
    }

    @Test
    void test5() {
        assertEquals("0.0(3)", new Solution().fractionToDecimal(1, 30));
    }

    @Test
    void test6() {
        assertEquals("0.0(3)", new Solution().fractionToDecimal(1, 30));
    }

    @Test
    void test7() {
        assertEquals("0.0029296875", new Solution().fractionToDecimal(3, 1024));
    }

    @Test
    void test8() {
        assertEquals("0.0000000004656612873077392578125", new Solution().fractionToDecimal(-1, Integer.MIN_VALUE));
    }
}