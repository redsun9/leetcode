package raiffeisen.day2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SevenBlockReaderTest {

    @Test
    void test1() {
        String str =
                "._. ... ._. ._. ... ._. ._. ._. ._. ._.\n" +
                        "|.| ..| ._| ._| |_| |_. |_. ..| |_| |_|\n" +
                        "|_| ..| |_. ._| ..| ._| |_| ..| |_| ._|\n";
        String input = str.replace(" ", "").replace(".", " ");
        assertEquals(123456789L, SevenBlockReader.parseInt(input));
    }

    @Test
    void test2() {
        String str =
                "._. ._. ._. ._. ._. ._. ... ._. ._. ...\n" +
                        "|_. |_. ..| |_| |_| |.| ..| ._| ._| |_|\n" +
                        "._| |_| ..| |_| ._| |_| ..| |_. ._| ..|\n";
        String input = str.replace(" ", "").replace(".", " ");
        assertEquals(5678901234L, SevenBlockReader.parseInt(input));
    }
}