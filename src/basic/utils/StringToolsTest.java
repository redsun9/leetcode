package basic.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class StringToolsTest {

    @Test
    void manacherOdd() {
        assertArrayEquals(new int[]{1, 2, 2, 1, 1}, StringTools.manacherOdd("ababc"));
    }

    @Test
    void manacherEven() {
        assertArrayEquals(new int[]{0, 0, 0, 2, 0, 1}, StringTools.manacherEven("abaabb"));
    }
}