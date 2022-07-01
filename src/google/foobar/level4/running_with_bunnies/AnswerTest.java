package google.foobar.level4.running_with_bunnies;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AnswerTest {

    @Test
    void test1() {
        int[][] times = {{0, 1, 1, 1, 1}, {1, 0, 1, 1, 1}, {1, 1, 0, 1, 1}, {1, 1, 1, 0, 1}, {1, 1, 1, 1, 0}};
        int timeLimit = 3;
        int[] expected = {0, 1};
        int[] actual = Answer.answer(times, timeLimit);
        assertArrayEquals(expected, actual);
    }

    @Test
    void test2() {
        int[][] times = {{0, 2, 2, 2, -1}, {9, 0, 2, 2, -1}, {9, 3, 0, 2, -1}, {9, 3, 2, 0, -1}, {9, 3, 2, 2, 0}};
        int timeLimit = 1;
        int[] expected = {1, 2};
        int[] actual = Answer.answer(times, timeLimit);
        assertArrayEquals(expected, actual);
    }
}