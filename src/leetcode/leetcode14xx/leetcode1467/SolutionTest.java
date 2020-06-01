package leetcode.leetcode14xx.leetcode1467;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] balls = {1, 1};
        assertEquals(1.00000d, new Solution().getProbability(balls), 1e-5);
    }

    @Test
    void test2() {
        int[] balls = {2, 1, 1};
        assertEquals(0.66667d, new Solution().getProbability(balls), 1e-5);
    }

    @Test
    void test3() {
        int[] balls = {1, 2, 1, 2};
        assertEquals(0.60000d, new Solution().getProbability(balls), 1e-5);
    }

    @Test
    void test4() {
        int[] balls = {3, 2, 1};
        assertEquals(0.30000d, new Solution().getProbability(balls), 1e-5);
    }

    @Test
    void test5() {
        int[] balls = {6, 6, 6, 6, 6, 6};
        assertEquals(0.90327d, new Solution().getProbability(balls), 1e-5);
    }
}