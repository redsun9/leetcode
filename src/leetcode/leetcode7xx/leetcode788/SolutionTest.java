package leetcode.leetcode7xx.leetcode788;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(4, new Solution().rotatedDigits(10));
    }

    @Test
    void test2() {
        assertEquals(1, new Solution().rotatedDigits(2));
    }
}