package leetcode.leetcode17xx.leetcode1745;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        String s = "juchzcedhfesefhdeczhcujzzvbmoeombv";
        assertTrue(new Solution().checkPartitioning(s));
    }

    @Test
    void test2() {
        String s = "bbab";
        assertTrue(new Solution().checkPartitioning(s));
    }
}