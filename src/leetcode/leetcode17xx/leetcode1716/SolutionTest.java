package leetcode.leetcode17xx.leetcode1716;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(10, new Solution().totalMoney(4));
        assertEquals(37, new Solution().totalMoney(10));
        assertEquals(96, new Solution().totalMoney(20));
    }
}