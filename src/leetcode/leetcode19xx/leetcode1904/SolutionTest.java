package leetcode.leetcode19xx.leetcode1904;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String startTime = "12:01", finishTime = "12:44";
        assertEquals(1, new Solution().numberOfRounds(startTime, finishTime));
    }

    @Test
    void test2() {
        String startTime = "20:00", finishTime = "06:00";
        assertEquals(40, new Solution().numberOfRounds(startTime, finishTime));
    }
}