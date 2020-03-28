package leetcode.leetcode972;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void isRationalEqual() {
        Solution solution = new Solution();
        assertTrue(solution.isRationalEqual("0.(52)", "0.5(25)"));
        assertTrue(solution.isRationalEqual("1", "0.(9)"));
        assertTrue(solution.isRationalEqual("1.", "0.9(9)"));
        assertFalse(solution.isRationalEqual("8.123(4567)", "8.123(4566)"));
    }
}