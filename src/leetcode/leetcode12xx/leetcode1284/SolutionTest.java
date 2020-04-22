package leetcode.leetcode12xx.leetcode1284;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        Solution solution = new Solution();
        int[][] mat = new int[][]{{0, 0}, {0, 1}};
        assertEquals(3, solution.minFlips(mat));
    }

    @Test
    void test2() {
        Solution solution = new Solution();
        int[][] mat = new int[][]{{0}};
        assertEquals(0, solution.minFlips(mat));
    }

    @Test
    void test3() {
        Solution solution = new Solution();
        int[][] mat = new int[][]{{1, 1, 1}, {1, 0, 1}, {0, 0, 0}};
        assertEquals(6, solution.minFlips(mat));
    }

    @Test
    void test4() {
        Solution solution = new Solution();
        int[][] mat = new int[][]{{1, 0, 0}, {1, 0, 0}};
        assertEquals(-1, solution.minFlips(mat));
    }


}