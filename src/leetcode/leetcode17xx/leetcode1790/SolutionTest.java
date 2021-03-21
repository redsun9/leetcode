package leetcode.leetcode17xx.leetcode1790;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        assertTrue(new Solution().areAlmostEqual("bank", "kanb"));
    }

    @Test
    void test2() {
        assertFalse(new Solution().areAlmostEqual("attack", "defend"));
    }

    @Test
    void test3() {
        assertTrue(new Solution().areAlmostEqual("kelb", "kelb"));
    }

    @Test
    void test4() {
        assertFalse(new Solution().areAlmostEqual("abcd", "dcba"));
    }
}