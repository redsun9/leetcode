package leetcode.leetcode36xx.leetcode3614;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String s = "a#b%*";
        long k = 1;
        assertEquals('a', new Solution().processStr(s, k));
    }

    @Test
    void test2() {
        String s = "cd%#*#";
        long k = 3;
        assertEquals('d', new Solution().processStr(s, k));
    }

    @Test
    void test3() {
        String s = "z*#";
        long k = 0;
        assertEquals('.', new Solution().processStr(s, k));
    }
}