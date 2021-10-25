package leetcode.leetcode20xx.leetcode2050;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int n = 3;
        int[][] relations = {{1, 3}, {2, 3}};
        int[] time = {3, 2, 5};
        assertEquals(8, new Solution().minimumTime(n, relations, time));
    }

    @Test
    void test2() {
        int n = 5;
        int[][] relations = {{1, 5}, {2, 5}, {3, 5}, {3, 4}, {4, 5}};
        int[] time = {1, 2, 3, 4, 5};
        assertEquals(12, new Solution().minimumTime(n, relations, time));

    }
}