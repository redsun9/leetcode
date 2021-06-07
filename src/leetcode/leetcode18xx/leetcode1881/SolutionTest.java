package leetcode.leetcode18xx.leetcode1881;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals("999", new Solution().maxValue("99", 9));
    }

    @Test
    void test2() {
        assertEquals("-123", new Solution().maxValue("-13", 2));
    }

    @Test
    void test3() {
        assertEquals("345218", new Solution().maxValue("34518", 2));
    }

    @Test
    void test4() {
        assertEquals(
                "4699757879438632651173569913153377",
                new Solution().maxValue("469975787943862651173569913153377", 3)
        );
    }

    @Test
    void test5() {
        assertEquals("-1323", new Solution().maxValue("-132", 3));
    }
}