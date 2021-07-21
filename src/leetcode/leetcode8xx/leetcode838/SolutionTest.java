package leetcode.leetcode8xx.leetcode838;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals("RR.L", new Solution().pushDominoes("RR.L"));
    }

    @Test
    void test2() {
        assertEquals("LL.RR.LLRRLL..", new Solution().pushDominoes(".L.R...LR..L.."));
    }
}