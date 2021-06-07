package leetcode.leetcode18xx.leetcode1888;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(2, new Solution().minFlips("111000"));
    }

    @Test
    void test2() {
        assertEquals(0, new Solution().minFlips("010"));
    }

    @Test
    void test3() {
        assertEquals(1, new Solution().minFlips("1110"));
    }

    @Test
    void test4() {
        assertEquals(2, new Solution().minFlips("01001001101"));
    }
}