package leetcode.leetcode22xx.leetcode2211;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(5, new Solution().countCollisions("RLRSLL"));
    }

    @Test
    void test2() {
        assertEquals(0, new Solution().countCollisions("LLRR"));
    }
}