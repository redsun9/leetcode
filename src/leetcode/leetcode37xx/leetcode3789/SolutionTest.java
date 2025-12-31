package leetcode.leetcode37xx.leetcode3789;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void minimumCost() {
        assertEquals(3, new Solution().minimumCost(3, 2, 1, 3, 2));
        assertEquals(22, new Solution().minimumCost(5, 4, 15, 2, 3));
    }
}