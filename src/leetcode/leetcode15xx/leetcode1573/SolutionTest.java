package leetcode.leetcode15xx.leetcode1573;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(4, new Solution().numWays("10101"));
    }

    @Test
    void test2() {
        assertEquals(0, new Solution().numWays("1001"));
    }

    @Test
    void test3() {
        assertEquals(3, new Solution().numWays("0000"));
    }

    @Test
    void test4() {
        assertEquals(12, new Solution().numWays("100100010100110"));
    }
}