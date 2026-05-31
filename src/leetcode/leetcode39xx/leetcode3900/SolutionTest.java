package leetcode.leetcode39xx.leetcode3900;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(4, new Solution().longestBalanced("100001"));
    }

    @Test
    void test2() {
        assertEquals(0, new Solution().longestBalanced("111"));
    }
}