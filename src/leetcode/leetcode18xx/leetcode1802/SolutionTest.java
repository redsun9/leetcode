package leetcode.leetcode18xx.leetcode1802;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(2, new Solution().maxValue(4, 2, 6));
    }

    @Test
    void test2() {
        assertEquals(3, new Solution().maxValue(6, 1, 10));
    }
}