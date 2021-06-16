package leetcode.leetcode6xx.leetcode699;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[][] positions = {{1, 2}, {2, 3}, {6, 1}};
        List<Integer> expected = List.of(2, 5, 5);
        assertEquals(expected, new Solution().fallingSquares(positions));
    }

    @Test
    void test2() {
        int[][] positions = {{100, 100}, {200, 100}};
        List<Integer> expected = List.of(100, 100);
        assertEquals(expected, new Solution().fallingSquares(positions));
    }

    @Test
    void test3() {
        int[][] positions = {{4, 9}, {8, 8}, {6, 8}, {8, 2}, {1, 2}};
        List<Integer> expected = List.of(9, 17, 25, 27, 27);
        assertEquals(expected, new Solution().fallingSquares(positions));
    }
}