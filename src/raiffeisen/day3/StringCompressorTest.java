package raiffeisen.day3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class StringCompressorTest {

    @Test
    void test1() {
        assertEquals("5A", StringCompressor.compress("AAAAA"));
    }

    @Test
    void test2() {
        assertEquals("5A3BC", StringCompressor.compress("AAAAABBBC"));
    }

    @Test
    void test3() {
        assertEquals("", StringCompressor.compress(""));
    }

    @Test
    void test4() {
        assertNull(StringCompressor.compress(null));
    }

    @Test
    void test5() {
        assertEquals("ABC", StringCompressor.compress("ABC"));
    }

    @Test
    void test6() {
        assertEquals("A5BC", StringCompressor.compress("ABBBBBC"));
    }

}