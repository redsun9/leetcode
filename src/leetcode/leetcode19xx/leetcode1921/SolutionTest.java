package leetcode.leetcode19xx.leetcode1921;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] dist = {1, 3, 4}, speed = {1, 1, 1};
        assertEquals(3, new Solution().eliminateMaximum(dist, speed));
    }

    @Test
    void test2() {
        int[] dist = {1, 1, 2, 3}, speed = {1, 1, 1, 1};
        assertEquals(1, new Solution().eliminateMaximum(dist, speed));
    }

    @Test
    void test3() {
        int[] dist = {3, 2, 4}, speed = {5, 3, 2};
        assertEquals(1, new Solution().eliminateMaximum(dist, speed));
    }
}