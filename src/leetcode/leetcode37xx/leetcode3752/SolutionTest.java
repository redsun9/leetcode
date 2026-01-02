package leetcode.leetcode37xx.leetcode3752;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void lexSmallestNegatedPerm() {
        assertArrayEquals(new int[]{-3, 1, 2}, new Solution().lexSmallestNegatedPerm(3, 0));
    }
}