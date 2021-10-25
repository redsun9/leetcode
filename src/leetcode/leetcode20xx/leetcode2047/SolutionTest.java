package leetcode.leetcode20xx.leetcode2047;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String s = "cat and  dog";
        assertEquals(3, new Solution().countValidWords(s));
    }

    @Test
    void test2() {
        String s = "!this  1-s b8d!";
        assertEquals(0, new Solution().countValidWords(s));
    }

    @Test
    void test3() {
        String s = "alice and  bob are playing stone-game10";
        assertEquals(5, new Solution().countValidWords(s));
    }

    @Test
    void test4() {
        String s = "he bought 2 pencils, 3 erasers, and 1  pencil-sharpener.";
        assertEquals(6, new Solution().countValidWords(s));
    }

    @Test
    void test5() {
        String s = "a.a b-!  -c. !";
        assertEquals(1, new Solution().countValidWords(s));
    }
}