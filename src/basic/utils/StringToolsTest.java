package basic.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

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


    @Test
    void testLcs2() {
        String x = "asdjauhfdgysf", y = "sdjnfsjdhvsgvcs";
        String actual = StringTools.lcs(x, y);
        assertEquals("sdjfdgs", actual);
    }

    @Test
    void testLcs3() {
        String x = "asbvasdad", y = "avdbvada", z = "asvsbvavsas";
        String actual = StringTools.lcs(x, y, z);
        assertEquals("abvaa", actual);
    }
}