package leetcode.leetcode37xx.leetcode3704;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(1L, new Solution().countNoZeroPairs(2));
    }

    @Test
    void test2() {
        assertEquals(2L, new Solution().countNoZeroPairs(3));
    }

    @Test
    void test3() {
        assertEquals(8L, new Solution().countNoZeroPairs(11));
    }
}