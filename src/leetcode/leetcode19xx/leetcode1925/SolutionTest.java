package leetcode.leetcode19xx.leetcode1925;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(2, new Solution().countTriples(5));
    }

    @Test
    void test2() {
        assertEquals(4, new Solution().countTriples(10));
    }

    @Test
    void test3() {
        assertEquals(10, new Solution().countTriples(18));
    }
}