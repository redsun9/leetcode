package leetcode.leetcode13xx.leetcode1360;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String date1 = "2019-06-29", date2 = "2019-06-30";
        assertEquals(1, new Solution().daysBetweenDates(date1, date2));
    }

    @Test
    void test2() {
        String date1 = "2020-01-15", date2 = "2019-12-31";
        assertEquals(15, new Solution().daysBetweenDates(date1, date2));
    }
}