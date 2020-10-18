package leetcode.leetcode16xx.leetcode1625;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals("2050", new Solution().findLexSmallestString("5525", 9, 2));
    }

    @Test
    void test2() {
        assertEquals("24", new Solution().findLexSmallestString("74", 5, 1));
    }

    @Test
    void test3() {
        assertEquals("0011", new Solution().findLexSmallestString("0011", 4, 2));
    }

    @Test
    void test4() {
        assertEquals("00553311", new Solution().findLexSmallestString("43987654", 7, 3));
    }
}