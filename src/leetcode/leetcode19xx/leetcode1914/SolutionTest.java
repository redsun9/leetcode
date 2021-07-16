package leetcode.leetcode19xx.leetcode1914;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void test1() {
        int[][] input = {
                {4, 5, 8, 9, 4, 2, 4, 7, 2, 4},
                {7, 1, 9, 6, 6, 1, 4, 5, 7, 7},
                {7, 1, 5, 1, 1, 7, 10, 1, 3, 1},
                {7, 2, 2, 5, 2, 6, 6, 4, 7, 7},
                {1, 2, 3, 8, 4, 7, 6, 9, 6, 2},
                {5, 10, 3, 4, 7, 2, 7, 5, 3, 10}
        };
        new Solution().rotateGrid(input, 4);
    }
}