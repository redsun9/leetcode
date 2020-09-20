package leetcode.leetcode15xx.leetcode1592;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String text = "  this   is  a sentence ";
        String expected = "this   is   a   sentence";
        assertEquals(expected, new Solution().reorderSpaces(text));
    }

    @Test
    void test2() {
        String text = " practice   makes   perfect";
        String expected = "practice   makes   perfect ";
        assertEquals(expected, new Solution().reorderSpaces(text));
    }

    @Test
    void test3() {
        String text = "hello   world";
        String expected = "hello   world";
        assertEquals(expected, new Solution().reorderSpaces(text));
    }

    @Test
    void test4() {
        String text = "  walks  udp package   into  bar a";
        String expected = "walks  udp  package  into  bar  a ";
        assertEquals(expected, new Solution().reorderSpaces(text));
    }

    @Test
    void test5() {
        String text = "a";
        String expected = "a";
        assertEquals(expected, new Solution().reorderSpaces(text));
    }
}
