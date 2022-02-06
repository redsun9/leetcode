package leetcode.leetcode21xx.leetcode2146;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] grid = {{1, 2, 0, 1}, {1, 3, 0, 1}, {0, 2, 5, 1}};
        int[] pricing = {2, 5}, start = {0, 0};
        int k = 3;
        List<List<Integer>> expected = List.of(List.of(0, 1), List.of(1, 1), List.of(2, 1));
        assertEquals(expected, new Solution().highestRankedKItems(grid, pricing, start, k));
    }

    @Test
    void test2() {
        int[][] grid = {{1, 2, 0, 1}, {1, 3, 3, 1}, {0, 2, 5, 1}};
        int[] pricing = {2, 3}, start = {2, 3};
        int k = 2;
        List<List<Integer>> expected = List.of(List.of(2, 1), List.of(1, 2));
        assertEquals(expected, new Solution().highestRankedKItems(grid, pricing, start, k));
    }

    @Test
    void test3() {
        int[][] grid = {{1, 1, 1}, {0, 0, 1}, {2, 3, 4}};
        int[] pricing = {2, 3}, start = {0, 0};
        int k = 3;
        List<List<Integer>> expected = List.of(List.of(2, 1), List.of(2, 0));
        assertEquals(expected, new Solution().highestRankedKItems(grid, pricing, start, k));
    }
}