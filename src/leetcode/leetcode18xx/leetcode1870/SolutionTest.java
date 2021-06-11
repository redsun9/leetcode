package leetcode.leetcode18xx.leetcode1870;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] dist = {1, 3, 2};
        double hour = 6;
        assertEquals(1, new Solution().minSpeedOnTime(dist, hour));
    }

    @Test
    void test2() {
        int[] dist = {1, 3, 2};
        double hour = 2.7;
        assertEquals(3, new Solution().minSpeedOnTime(dist, hour));
    }

    @Test
    void test3() {
        int[] dist = {1, 3, 2};
        double hour = 1.9;
        assertEquals(-1, new Solution().minSpeedOnTime(dist, hour));
    }

    @Test
    void test4() {
        int[] dist = {1, 3, 2, 100};
        double hour = 3.7;
        assertEquals(143, new Solution().minSpeedOnTime(dist, hour));
    }

    @Test
    void test5() {
        int[] dist = {10, 20, 30, 10};
        double hour = 12.11;
        assertEquals(7, new Solution().minSpeedOnTime(dist, hour));
    }
}