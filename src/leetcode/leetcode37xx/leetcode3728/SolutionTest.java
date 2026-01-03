package leetcode.leetcode37xx.leetcode3728;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void countStableSubarrays() {
        assertEquals(2, new Solution().countStableSubarrays(new int[]{9, 3, 3, 3, 9}));
        assertEquals(1, new Solution().countStableSubarrays(new int[]{-4, 4, 0, 0, -8, -4}));
    }
}