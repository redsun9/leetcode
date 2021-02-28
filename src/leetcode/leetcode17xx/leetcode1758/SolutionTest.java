package leetcode.leetcode17xx.leetcode1758;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(1, new Solution().minOperations("0100"));
    }

    @Test
    void test2() {
        assertEquals(0, new Solution().minOperations("10"));
    }

    @Test
    void test3() {
        assertEquals(2, new Solution().minOperations("1111"));
    }
}