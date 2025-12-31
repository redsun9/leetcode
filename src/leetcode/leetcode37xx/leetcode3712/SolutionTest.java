package leetcode.leetcode37xx.leetcode3712;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void sumDivisibleByK() {
        assertEquals(16, new Solution().sumDivisibleByK(new int[]{1, 2, 2, 3, 3, 3, 3, 4}, 2));
        assertEquals(16, new Solution2().sumDivisibleByK(new int[]{1, 2, 2, 3, 3, 3, 3, 4}, 2));
    }
}