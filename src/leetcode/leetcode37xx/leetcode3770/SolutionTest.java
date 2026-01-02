package leetcode.leetcode37xx.leetcode3770;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void largestPrime() {
        assertEquals(17, new Solution().largestPrime(20));
        assertEquals(2, new Solution().largestPrime(2));
    }
}