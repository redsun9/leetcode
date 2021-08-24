package basic.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@SuppressWarnings("SpellCheckingInspection")
class StringToolsTest {

    @Test
    void zFunction() {
        String s = "abacaba";
        int[] expected = {0, 0, 1, 0, 3, 0, 1};
        int[] actual = StringTools.zFunction(s);
        assertArrayEquals(expected, actual);
    }

    @Test
    void prefFunction() {
        String s = "abcabcd";
        int[] expected = {0, 0, 0, 1, 2, 3, 0};
        int[] actual = StringTools.prefixFunction(s);
        assertArrayEquals(expected, actual);
    }

    @Test
    void manacherOdd() {
        assertArrayEquals(new int[]{1, 2, 2, 1, 1}, StringTools.manacherOdd("ababc"));
    }

    @Test
    void manacherEven() {
        assertArrayEquals(new int[]{0, 0, 0, 2, 0, 1}, StringTools.manacherEven("abaabb"));
    }
}