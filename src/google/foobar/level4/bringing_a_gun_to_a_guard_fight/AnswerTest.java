package google.foobar.level4.bringing_a_gun_to_a_guard_fight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnswerTest {
    @Test
    void test1() {
        int[] dimensions = {3, 2};
        int[] myPosition = {1, 1};
        int[] guardPosition = {2, 1};
        int distance = 4;
        assertEquals(7, Answer.answer(dimensions, myPosition, guardPosition, distance));
    }

    @Test
    void test2() {
        int[] dimensions = {300, 275};
        int[] myPosition = {150, 150};
        int[] guardPosition = {185, 100};
        int distance = 500;
        assertEquals(9, Answer.answer(dimensions, myPosition, guardPosition, distance));
    }
}