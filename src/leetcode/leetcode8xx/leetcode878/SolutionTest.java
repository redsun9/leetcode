package leetcode.leetcode8xx.leetcode878;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(8, new Solution().nthMagicalNumber(3, 6, 4));
    }

    @Test
    void test2() {
        assertEquals(15, new Solution().nthMagicalNumber(5, 7, 5));
    }
}