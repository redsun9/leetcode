package leetcode.leetcode37xx.leetcode3707;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void scoreBalance() {
        assertTrue(new Solution().scoreBalance("adcb"));
        assertFalse(new Solution().scoreBalance("bace"));
    }
}