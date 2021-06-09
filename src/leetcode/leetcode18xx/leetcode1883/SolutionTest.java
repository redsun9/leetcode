package leetcode.leetcode18xx.leetcode1883;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] dist = {1, 3, 2};
        int speed = 4, hoursBefore = 2;
        assertEquals(1, new Solution().minSkips(dist, speed, hoursBefore));
    }

    @Test
    void test2() {
        int[] dist = {7, 3, 5, 5};
        int speed = 2, hoursBefore = 10;
        assertEquals(2, new Solution().minSkips(dist, speed, hoursBefore));
    }

    @Test
    void test3() {
        int[] dist = {7, 3, 5, 5};
        int speed = 1, hoursBefore = 10;
        assertEquals(-1, new Solution().minSkips(dist, speed, hoursBefore));
    }
}