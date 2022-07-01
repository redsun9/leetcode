package google.foobar.level1.minion_task_scheduling;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AnswerTest {
    @Test
    void test1() {
        int[] data = {1, 2, 3};
        int n = 0;
        int[] expected = {};
        assertArrayEquals(expected, Answer.answer(data, n));
    }

    @Test
    void test2() {
        int[] data = {1, 2, 2, 3, 3, 3, 4, 5, 5};
        int n = 1;
        int[] expected = {1, 4};
        assertArrayEquals(expected, Answer.answer(data, n));
    }

    @Test
    void test3() {
        int[] data = {1, 2, 3};
        int n = 6;
        int[] expected = {1, 2, 3};
        assertArrayEquals(expected, Answer.answer(data, n));
    }
}