package leetcode.leetcode33xx.leetcode3348;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String num = "1234";
        long t = 256;
        String expected = "1488";
        assertEquals(expected, new Solution().smallestNumber(num, t));
    }

    @Test
    void test2() {
        String num = "12355";
        long t = 50;
        String expected = "12355";
        assertEquals(expected, new Solution().smallestNumber(num, t));
    }

    @Test
    void test3() {
        String num = "11111";
        long t = 26;
        String expected = "-1";
        assertEquals(expected, new Solution().smallestNumber(num, t));
    }
}