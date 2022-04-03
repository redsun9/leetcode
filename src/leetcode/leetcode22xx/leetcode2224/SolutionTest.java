package leetcode.leetcode22xx.leetcode2224;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void test1() {
        String current = "02:30", correct = "04:35";
        assertEquals(3, new Solution().convertTime(current, correct));
    }

    @Test
    void test2() {
        String current = "11:00", correct = "11:01";
        assertEquals(1, new Solution().convertTime(current, correct));
    }
}