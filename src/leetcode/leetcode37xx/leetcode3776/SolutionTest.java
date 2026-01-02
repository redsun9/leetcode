package leetcode.leetcode37xx.leetcode3776;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void minMoves() {
        assertEquals(4, new Solution().minMoves(new int[]{5, 1, -4}));
        assertEquals(6, new Solution().minMoves(new int[]{1, 2, -5, 2}));
        assertEquals(-1, new Solution().minMoves(new int[]{-3, 2}));

    }
}