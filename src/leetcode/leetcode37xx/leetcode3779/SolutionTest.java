package leetcode.leetcode37xx.leetcode3779;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void minOperations() {
        assertEquals(1, new Solution().minOperations(new int[]{3, 8, 3, 6, 5, 8}));
        assertEquals(0, new Solution().minOperations(new int[]{4, 3, 5, 1, 2}));

    }
}