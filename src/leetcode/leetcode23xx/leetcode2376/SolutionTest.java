package leetcode.leetcode23xx.leetcode2376;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(19, new Solution().countSpecialNumbers(20));
    }

    @Test
    void test2() {
        assertEquals(5, new Solution().countSpecialNumbers(5));
    }

    @Test
    void test3() {
        assertEquals(110, new Solution().countSpecialNumbers(135));
    }
}