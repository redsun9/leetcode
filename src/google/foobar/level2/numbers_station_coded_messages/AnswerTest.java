package google.foobar.level2.numbers_station_coded_messages;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AnswerTest {

    @Test
    void test1() {
        int[] nums = {4, 3, 10, 2, 8};
        int target = 12;
        int[] expected = {2, 3};
        assertArrayEquals(expected, Answer.answer(nums, target));
    }

    @Test
    void test2() {
        int[] nums = {1, 2, 3, 4};
        int target = 15;
        int[] expected = {-1, -1};
        assertArrayEquals(expected, Answer.answer(nums, target));
    }
}