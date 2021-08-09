package leetcode.leetcode9xx.leetcode902;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String[] digits = {"1", "3", "5", "7"};
        assertEquals(20, new Solution().atMostNGivenDigitSet(digits, 100));
    }

    @Test
    void test2() {
        String[] digits = {"1", "4", "9"};
        assertEquals(29523, new Solution().atMostNGivenDigitSet(digits, 1000000000));
    }

    @Test
    void test3() {
        String[] digits = {"7"};
        assertEquals(1, new Solution().atMostNGivenDigitSet(digits, 8));
    }

    @Test
    void test4() {
        String[] digits = {"1", "3", "5", "7"};
        assertEquals(6, new Solution().atMostNGivenDigitSet(digits, 13));
    }

    @Test
    void test5() {
        String[] digits = {"5", "6"};
        assertEquals(2, new Solution().atMostNGivenDigitSet(digits, 19));
    }
}