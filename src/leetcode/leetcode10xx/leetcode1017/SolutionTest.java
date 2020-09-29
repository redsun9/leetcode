package leetcode.leetcode10xx.leetcode1017;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals("110", new Solution().baseNeg2(2));
    }

    @Test
    void test2() {
        assertEquals("111", new Solution().baseNeg2(3));
    }

    @Test
    void test3() {
        assertEquals("100", new Solution().baseNeg2(4));
    }
}