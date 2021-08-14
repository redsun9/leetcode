package leetcode.leetcode7xx.leetcode754;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(5, new Solution().reachNumber(5));
    }

    @Test
    void test2() {
        assertEquals(3, new Solution().reachNumber(2));
    }
}