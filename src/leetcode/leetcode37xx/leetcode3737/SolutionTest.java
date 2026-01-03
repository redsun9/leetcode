package leetcode.leetcode37xx.leetcode3737;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void countMajoritySubarrays() {
        assertEquals(5, new Solution().countMajoritySubarrays(new int[]{1, 2, 2, 3}, 2));
    }
}