package leetcode.leetcode3xx.leetcode372;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int a = 2;
        int[] b = {3};
        assertEquals(8, new Solution().superPow(a, b));
    }

    @Test
    void test2() {
        int a = 2;
        int[] b = {1, 0};
        assertEquals(1024, new Solution().superPow(a, b));
    }
}