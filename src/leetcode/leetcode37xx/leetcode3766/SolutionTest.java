package leetcode.leetcode37xx.leetcode3766;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void minOperations() {
        assertArrayEquals(new int[]{0, 1, 1}, new Solution().minOperations(new int[]{1, 2, 4}));
    }
}