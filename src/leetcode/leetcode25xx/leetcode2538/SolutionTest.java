package leetcode.leetcode25xx.leetcode2538;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void maxOutput() {
        int n = 8;
        int[][] edges = {{1, 7}, {2, 3}, {4, 0}, {5, 7}, {6, 3}, {3, 0}, {0, 7}};
        int[] price = {4, 5, 6, 2, 2, 7, 7, 8};

        assertEquals(21, new Solution().maxOutput(n, edges, price));
    }
}