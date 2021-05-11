package leetcode.leetcode18xx.leetcode1844;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals("abcdef", new Solution().replaceDigits("a1c1e1"));
    }

    @Test
    void test2() {
        assertEquals("abbdcfdhe", new Solution().replaceDigits("a1b2c3d4e"));
    }
}