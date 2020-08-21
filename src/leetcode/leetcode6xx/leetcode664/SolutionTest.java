package leetcode.leetcode6xx.leetcode664;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(2, new Solution().strangePrinter("aaabbb"));
        assertEquals(2, new Solution2().strangePrinter("aaabbb"));
    }

    @Test
    void test2() {
        assertEquals(2, new Solution().strangePrinter("aba"));
        assertEquals(2, new Solution2().strangePrinter("aba"));
    }
}