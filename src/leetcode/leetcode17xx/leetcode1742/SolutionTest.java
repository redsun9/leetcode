package leetcode.leetcode17xx.leetcode1742;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(2, new Solution().countBalls(1, 10));
    }

    @Test
    void test2() {
        assertEquals(2, new Solution().countBalls(5, 15));
    }

    @Test
    void test3() {
        assertEquals(2, new Solution().countBalls(19, 28));
    }

    @Test
    void test4() {
        assertEquals(1, new Solution().countBalls(99999, 99999));
    }
}