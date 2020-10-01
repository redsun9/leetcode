package leetcode.leetcode12xx.leetcode1234;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(0, new Solution().balancedString("QWER"));
    }

    @Test
    void test2() {
        assertEquals(1, new Solution().balancedString("QQWE"));
    }

    @Test
    void test3() {
        assertEquals(2, new Solution().balancedString("QQQW"));
    }

    @Test
    void test4() {
        assertEquals(3, new Solution().balancedString("QQQQ"));
    }
}