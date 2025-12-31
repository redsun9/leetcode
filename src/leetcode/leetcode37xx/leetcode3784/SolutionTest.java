package leetcode.leetcode37xx.leetcode3784;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void minCost() {
        assertEquals(11, new Solution().minCost("aabaac", new int[]{1, 2, 3, 4, 1, 10}));
    }
}