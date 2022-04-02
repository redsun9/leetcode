package leetcode.leetcode22xx.leetcode2222;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void test1() {
        String s = "001101";
        assertEquals(6, new Solution().numberOfWays(s));
    }

    @Test
    void test2() {
        String s = "11100";
        assertEquals(0, new Solution().numberOfWays(s));
    }
}