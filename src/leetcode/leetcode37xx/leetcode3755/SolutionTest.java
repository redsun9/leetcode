package leetcode.leetcode37xx.leetcode3755;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void maxBalancedSubarray() {
        assertEquals(4, new Solution().maxBalancedSubarray(new int[]{3, 1, 3, 2, 0}));
        assertEquals(8, new Solution().maxBalancedSubarray(new int[]{3, 2, 8, 5, 4, 14, 9, 15}));
    }
}