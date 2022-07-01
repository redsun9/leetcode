package google.foobar.level3.find_the_access_codes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnswerTest {
    @Test
    void test1() {
        int[] nums = {1, 1, 1};
        assertEquals(1, Answer.answer(nums));
        assertEquals(1, Answer.answer2(nums));
    }

    @Test
    void test2() {
        int[] nums = {1, 2, 3, 4, 5, 6};
        assertEquals(3, Answer.answer(nums));
        assertEquals(3, Answer.answer2(nums));
    }
}