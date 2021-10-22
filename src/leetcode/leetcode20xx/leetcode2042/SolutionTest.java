package leetcode.leetcode20xx.leetcode2042;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        String s = "1 box has 3 blue 4 red 6 green and 12 yellow marbles";
        assertTrue(new Solution().areNumbersAscending(s));
    }

    @Test
    void test2() {
        String s = "hello world 5 x 5";
        assertFalse(new Solution().areNumbersAscending(s));
    }

    @Test
    void test3() {
        String s = "sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s";
        assertFalse(new Solution().areNumbersAscending(s));
    }

    @Test
    void test4() {
        String s = "4 5 11 26";
        assertTrue(new Solution().areNumbersAscending(s));
    }
}