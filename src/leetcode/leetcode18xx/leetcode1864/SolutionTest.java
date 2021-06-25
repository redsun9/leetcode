package leetcode.leetcode18xx.leetcode1864;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(1, new Solution().minSwaps("111000"));
    }

    @Test
    void test2() {
        assertEquals(0, new Solution().minSwaps("010"));
    }

    @Test
    void test3() {
        assertEquals(-1, new Solution().minSwaps("1110"));
    }
}