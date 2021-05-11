package leetcode.leetcode18xx.leetcode1847;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] rooms = {{2, 2}, {1, 2}, {3, 2}};
        int[][] queries = {{3, 1}, {3, 3}, {5, 2}};
        int[] expected = {3, -1, 3};
        assertArrayEquals(expected, new Solution().closestRoom(rooms, queries));
    }

    @Test
    void test2() {
        int[][] rooms = {{1, 4}, {2, 3}, {3, 5}, {4, 1}, {5, 2}};
        int[][] queries = {{2, 3}, {2, 4}, {2, 5}};
        int[] expected = {2, 1, 3};
        assertArrayEquals(expected, new Solution().closestRoom(rooms, queries));
    }
}