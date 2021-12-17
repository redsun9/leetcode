package leetcode.leetcode21xx.leetcode2106;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] fruits = {{2, 8}, {6, 3}, {8, 6}};
        int startPos = 5, k = 4, expected = 9;
        assertEquals(expected, new Solution().maxTotalFruits(fruits, startPos, k));
    }

    @Test
    void test2() {
        int[][] fruits = {{0, 9}, {4, 1}, {5, 7}, {6, 2}, {7, 4}, {10, 9}};
        int startPos = 5, k = 4, expected = 14;
        assertEquals(expected, new Solution().maxTotalFruits(fruits, startPos, k));
    }

    @Test
    void test3() {
        int[][] fruits = {{0, 3}, {6, 4}, {8, 5}};
        int startPos = 3, k = 2, expected = 0;
        assertEquals(expected, new Solution().maxTotalFruits(fruits, startPos, k));
    }

    @Test
    void test4() {
        int[][] fruits = {{200000, 10000}};
        int startPos = 200000, k = 200000, expected = 10000;
        assertEquals(expected, new Solution().maxTotalFruits(fruits, startPos, k));
    }
}