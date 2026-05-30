package leetcode.leetcode39xx.leetcode3932;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int l = 1, r = 9, k = 3, expected = 2;
        assertEquals(expected, new Solution().countKthRoots(l, r, k));
    }

    @Test
    void test2() {
        int l = 8, r = 30, k = 2, expected = 3;
        assertEquals(expected, new Solution().countKthRoots(l, r, k));
    }
}