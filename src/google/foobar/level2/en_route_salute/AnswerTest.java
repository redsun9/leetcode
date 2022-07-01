package google.foobar.level2.en_route_salute;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnswerTest {
    @Test
    void test1() {
        String s = ">----<";
        assertEquals(2, Answer.answer(s));

    }

    @Test
    void test2() {
        String s = "<<>><";
        assertEquals(4, Answer.answer(s));
    }
}