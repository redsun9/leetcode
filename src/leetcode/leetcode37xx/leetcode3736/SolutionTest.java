package leetcode.leetcode37xx.leetcode3736;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void minMoves() {
        assertEquals(3, new Solution().minMoves(new int[]{2, 1, 3}));
        assertEquals(2, new Solution().minMoves(new int[]{4, 4, 5}));
    }
}