package leetcode.leetcode17xx.leetcode1753;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(6, new Solution().maximumScore(2, 4, 6));
    }

    @Test
    void test2() {
        assertEquals(7, new Solution().maximumScore(4, 4, 6));
    }

    @Test
    void test3() {
        assertEquals(8, new Solution().maximumScore(1, 8, 8));
    }
}